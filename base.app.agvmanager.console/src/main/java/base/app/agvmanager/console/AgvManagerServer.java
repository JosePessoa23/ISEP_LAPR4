package base.app.agvmanager.console;

import base.app.agvmanager.console.Http.HttpAjaxVotingRequest;
import eapli.base.order.domain.Product_Order;
import eapli.base.transition.GetProductLocationController;
import eapli.base.warehouse.domain.AGVDocks;
import eapli.base.warehouse.domain.Roww;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.persistence.NoResultException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;


public class AgvManagerServer {

    static final int SERVER_PORT=10001;
    static final String TRUSTED_STORE="agvmanager_J.jks";
    static final String KEYSTORE_PASS="forgotten";

    public static void main(String args[]) throws Exception {
        SSLServerSocket sock=null;
        Socket cliSock;


        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore",TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);


        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            sock = (SSLServerSocket) sslF.createServerSocket(SERVER_PORT);
            sock.setNeedClientAuth(true);
        }
        catch(IOException ex) {
            System.out.println("Server failed to open local port " + SERVER_PORT);
            System.exit(1);
        }

            Sensor sensor = new Sensor();
            new Thread(new HttpThread(sensor)).start();

        while(true) {
            cliSock=sock.accept();
            new Thread(new AgvManagerThread(cliSock,sensor)).start();
        }
    }

    public static synchronized String getVotesStandingInHTML(Sensor sensor) {
        String textHtml = "<hr><p>"+ sensor.printMatrix() + "</p><hr>";
        return textHtml;
    }
}

class HttpThread implements Runnable {

    ServerSocket sock2;
    Socket cliSock2;

    String BASE_FOLDER="www";

    Sensor sensor;
    public HttpThread(Sensor sensor) {
        try { this.sock2 = new ServerSocket(8080); }
        catch(IOException ex) {
            System.out.println("Server failed to open local port " + 8080);
            System.exit(1);
        }
        this.sensor=sensor;
    }

    @Override
    public void run() {

        while(true) {
            try {
                cliSock2=sock2.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            HttpAjaxVotingRequest req=new HttpAjaxVotingRequest(cliSock2, BASE_FOLDER,sensor);
            req.start();
        }

    }
}


class AgvManagerThread implements Runnable {

    private final Sensor sensor;
    private final Socket s;

    private boolean flagX = true;
    private boolean flagY = true;

    private boolean notify = false;

    public AgvManagerThread(Socket cli_s,Sensor sensor) {
        s = cli_s;
        this.sensor = sensor;
    }

    public void run() {
        InetAddress clientIP;

        clientIP = s.getInetAddress();
        System.out.println("New client connection from " + clientIP.getHostAddress() +
                ", port number " + s.getPort());
        try {
            DataOutputStream sOut = new DataOutputStream(s.getOutputStream());
            DataInputStream sIn = new DataInputStream(s.getInputStream());
            byte[] message = new byte[5];
            byte[] response = new byte[5];
            do {
                sIn.read(message);
                if (message[1] == 0) {
                    System.out.println("Test request received.");
                    response[0] = 1;
                    response[1] = 2;
                    response[2] = 0;
                    response[3] = 0;
                    sOut.write(response);
                } else if (message[1] == 1) {
                    System.out.println("AGV disconnected.");
                    response[0] = 1;
                    response[1] = 2;
                    response[2] = 0;
                    response[3] = 0;
                    sOut.write(response);
                } else if (message[1] == 3) {
                    String agvid = new String(message);
                    agvid= "D"+ agvid.charAt(4);
                    GetProductLocationController getProductLocationController = new GetProductLocationController();
                    try {
                        AGVDocks agvDocks = getProductLocationController.getAgvLocation(agvid);
                        int time = 1000/agvDocks.agv().agvSpeed();
                        int inicialx = agvDocks.beginl() - 1;
                        int inicialy = agvDocks.beginw() - 1;
                        int xActual = inicialx;
                        int yActual = inicialy;

                        HashMap<Product_Order, List<Roww>> order_row = getProductLocationController.getProductLocation();
                        Product_Order order = order_row.keySet().iterator().next();
                    for(Roww r:order_row.get(order)){
                        String accessibility = getProductLocationController.getAccessibility(r);
                        int yproduto;
                        int xproduto;
                        if(accessibility.contains("+")) {
                            yproduto = r.beginw();
                            xproduto = (r.beginl() + r.endl()) / 2;
                        }else{
                            yproduto = r.beginw()-2;
                            xproduto = (r.beginl() + r.endl()) / 2;
                        }
                        moveAroundWarehouse(xActual, yActual, xproduto, yproduto, time);
                        xActual = xproduto;
                        yActual = yproduto;
                    }
                    moveAroundWarehouse(xActual, yActual,inicialx,inicialy, time);
                    if(agvDocks.accessibility().contains("+")) {
                        sensor.enterAgvDock(inicialx+1, inicialy);
                    }else{
                        sensor.enterAgvDock(inicialx-1, inicialy);
                    }
                    getProductLocationController.setOrderReady(order);
                    getProductLocationController.freeAGV(agvid);
                    }catch (NoResultException e){
                        System.out.println("The AGV on the dock "+agvid+" is not available.");
                    }
                }
            } while (message[1] != 1);

            System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + s.getPort() +
                    " disconnected");
            s.close();
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }

    private void moveAroundWarehouse(int xActual,int yActual,int xProduct,int yProduct, int time){

        //movimento para fora do AGVDocks
        try {
            if (xActual > xProduct) {
                Thread.sleep(time);
                xActual=moveLeft(xActual,yActual,notify, time);
            } else if (xActual < xProduct) {
                Thread.sleep(time);
                xActual=moveRight(xActual,yActual,notify, time);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        do {
            try {

                //Normal movement
                if(flagX && flagY) {
                    if (yActual < yProduct) {
                        Thread.sleep(time);
                        yActual=moveDown(xActual,yActual,notify, time);
                    } else if (yActual > yProduct) {
                        Thread.sleep(time);
                        yActual=moveUp(xActual,yActual,notify, time);
                    } else {
                        if (xActual > xProduct) {
                            Thread.sleep(time);
                            xActual=moveLeft(xActual,yActual,notify, time);
                        } else if (xActual < xProduct) {
                            Thread.sleep(time);
                            xActual=moveRight(xActual,yActual,notify, time);
                        }
                    }

                    //In case finds and obstacle in X
                }else if(!flagX){

                    //Move down
                    if (yActual < yProduct) {
                        int yAux = yActual;
                        yActual=moveDown(xActual,yActual,notify, time);
                        if(yAux==yActual){
                            if (xActual > xProduct) {
                                xActual=moveRight(xActual,yActual,notify, time);
                            } else if (xActual < xProduct) {
                                xActual=moveLeft(xActual,yActual,notify, time);
                            }
                            Thread.sleep(time);
                            notify=true;
                            yActual=moveDown(xActual,yActual,notify, time);
                            notify=false;
                        }
                        flagY = true;
                        flagX = true;


                        //Move up
                    } else if (yActual > yProduct) {
                        int yAux = yActual;
                        yActual=moveUp(xActual,yActual,notify, time);
                        if(yAux==yActual){
                            if (xActual > xProduct) {
                                xActual=moveRight(xActual,yActual,notify, time);
                            } else if (xActual < xProduct) {
                                xActual=moveLeft(xActual,yActual,notify, time);
                            }
                            Thread.sleep(time);
                            notify=true;
                            yActual=moveUp(xActual,yActual,notify, time);
                            notify=false;
                        }
                        flagY = true;
                        flagX = true;
                    }else{
                        int yAux = yActual;
                        yActual=moveUp(xActual,yActual,notify, time);
                        if(yAux==yActual){
                            yActual=moveDown(xActual,yActual,notify, time);
                            if (xActual > xProduct) {
                                Thread.sleep(time);
                                notify=true;
                                xActual=moveLeft(xActual,yActual,notify, time);
                            } else if (xActual < xProduct) {
                                Thread.sleep(time);
                                notify=true;
                                xActual=moveRight(xActual,yActual,notify, time);
                            }
                            notify=false;
                        }
                        flagY = true;
                        flagX = true;
                    }


                    //In case finds and obstacle in Y
                }else if(!flagY){


                    if (xActual > xProduct) {
                        int xAux = xActual;
                        xActual=moveLeft(xActual,yActual,notify, time);
                        if(xAux==xActual){
                            if (yActual > yProduct) {
                                yActual=moveDown(xActual,yActual,notify, time);
                            } else if (yActual < yProduct) {
                                yActual=moveUp(xActual,yActual,notify, time);
                            }
                            Thread.sleep(time);
                            notify=true;
                            xActual=moveLeft(xActual,yActual,notify, time);
                            notify=false;
                        }
                        flagY = true;
                        flagX = true;



                    } else if (xActual < xProduct) {
                        int xAux = xActual;
                        xActual=moveRight(xActual,yActual,notify, time);
                        if(xAux==xActual){
                            if (yActual > yProduct) {
                                yActual=moveDown(xActual,yActual,notify, time);
                            } else if (yActual < yProduct) {
                                yActual=moveUp(xActual,yActual,notify, time);
                            }
                            Thread.sleep(time);
                            notify=true;
                            xActual=moveRight(xActual,yActual,notify, time);
                            notify=false;
                        }
                        flagY = true;
                        flagX = true;
                    }else{
                        int xAux = xActual;
                        xActual=moveRight(xActual,yActual,notify, time);
                        if(xAux==xActual){
                            xActual=moveLeft(xActual,yActual,notify, time);
                            if (yActual > yProduct) {
                                Thread.sleep(time);
                                notify=true;
                                yActual=moveDown(xActual,yActual,notify, time);
                            } else if (yActual < yProduct) {
                                Thread.sleep(time);
                                notify=true;
                                yActual=moveUp(xActual,yActual,notify, time);
                            }
                            notify=false;
                        }
                        flagY = true;
                        flagX = true;
                    }
                }



            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (xActual!=xProduct || yActual!=yProduct);
    }

    private int moveRight(int xActual,int yActual,boolean notify, int time) throws InterruptedException {
        int xAux = xActual;
        xActual = sensor.moveRight(xActual, yActual,notify, time);
        if (xActual==-1){
            xActual=xAux;
        }else if (xActual == xAux) {
            flagX = false;
        }
        return xActual;
    }

    private int moveLeft(int xActual,int yActual,boolean notify, int time) throws InterruptedException {
        int xAux = xActual;
        xActual = sensor.moveLeft(xActual, yActual,notify, time);
        if (xActual==-1){
            xActual=xAux;
        }else if (xActual == xAux) {
            flagX = false;
        }
        return xActual;
    }

    private int moveUp(int xActual,int yActual,boolean notify, int time) throws InterruptedException {
        int yAux = yActual;
        yActual = sensor.moveUp(xActual, yActual,notify, time);
        if (yActual==-1){
            yActual=yAux;
        }else if (yAux == yActual) {
            flagY = false;
        }
        return yActual;
    }

    private int moveDown(int xActual,int yActual,boolean notify, int time) throws InterruptedException {
        int yAux = yActual;
        yActual = sensor.moveDown(xActual, yActual,notify, time);
        if (yActual==-1){
            yActual=yAux;
        }else if(yAux == yActual) {
            flagY = false;
        }
        return yActual;
    }
}
