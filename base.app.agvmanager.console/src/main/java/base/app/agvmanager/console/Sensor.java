package base.app.agvmanager.console;

import eapli.base.warehouse.application.BuildWarehouseController;

import java.util.Objects;

public class Sensor {

    private final String[][] warehouse;

    private final String square="🔲";
    private final String parede="🧱";
    private final String agvdocks="🅿️";
    private final String wait="⌛";

    private final String cima="⬆️";

    private final String baixo="⬇️";

    private final String direita="➡️";

    private final String esquerda="⬅️";


    public Sensor(){
        BuildWarehouseController buildWarehouseController = new BuildWarehouseController();
        warehouse = buildWarehouseController.getWarehouseMatrix();
    }


    public synchronized int moveRight(int xActual, int yActual,boolean notify,int time) throws InterruptedException {
        if(warehouse[yActual][xActual+1].equals(square)){
            if(warehouse[yActual][xActual+2].equals(square)){
                if(!Objects.equals(warehouse[yActual][xActual], agvdocks)) {
                    warehouse[yActual][xActual] = square;
                }
                warehouse[yActual][xActual+1] = direita;
            }else{
                Thread.sleep(time);
                warehouse[yActual][xActual] = square;
                warehouse[yActual][xActual+1] = direita;
            }
        }else if(warehouse[yActual][xActual+1].equals(esquerda)){
            warehouse[yActual][xActual] = wait;
            wait();
            return -1;
        } else if(warehouse[yActual][xActual+1].equals(baixo) || warehouse[yActual][xActual+1].equals(direita) || warehouse[yActual][xActual+1].equals(cima) ){
            return -1;
        } else if(warehouse[yActual][xActual+1].equals(wait) || warehouse[yActual][xActual+1].equals(parede)){
            return xActual;
        }
        if (notify){
            notifyAll();
        }
        return xActual +1;
    }

    public synchronized int moveLeft(int xActual, int yActual,boolean notify,int time) throws InterruptedException {
        if(warehouse[yActual][xActual-1].equals(square)){
            if(warehouse[yActual][xActual-2].equals(square)){
                if(!Objects.equals(warehouse[yActual][xActual], agvdocks)) {
                    warehouse[yActual][xActual] = square;
                }
                warehouse[yActual][xActual-1] = esquerda;
            }else{
                Thread.sleep(time);
                warehouse[yActual][xActual] = square;
                warehouse[yActual][xActual-1] = esquerda;
            }
        }else if(warehouse[yActual][xActual-1].equals(direita)){
            warehouse[yActual][xActual] = wait;
            wait();
            return -1;
        } else if(warehouse[yActual][xActual-1].equals(baixo) || warehouse[yActual][xActual-1].equals(esquerda) || warehouse[yActual][xActual-1].equals(cima) ){
            return -1;
        } else if(warehouse[yActual][xActual-1].equals(wait) || warehouse[yActual][xActual-1].equals(parede)){
            return xActual;
        }
        if (notify){
            notifyAll();
        }
        return xActual -1;
    }


    public synchronized int moveUp(int xActual, int yActual,boolean notify,int time) throws InterruptedException {
        if(warehouse[yActual-1][xActual].equals(square)){
            if(warehouse[yActual-2][xActual].equals(square)){
                warehouse[yActual][xActual] = square;
                warehouse[yActual-1][xActual] = cima;
            }else{
                Thread.sleep(time);
                warehouse[yActual][xActual] = square;
                warehouse[yActual-1][xActual] = cima;
            }
        }else if( warehouse[yActual-1][xActual].equals(baixo)){
            warehouse[yActual][xActual] = wait;
            wait();
            return -1;
        } else if(warehouse[yActual-1][xActual].equals(direita) || warehouse[yActual-1][xActual].equals(esquerda) || warehouse[yActual-1][xActual].equals(cima) ){
            return -1;
        }else if(warehouse[yActual-1][xActual].equals(wait) || warehouse[yActual-1][xActual].equals(parede)){
            return yActual;
        }
        if (notify){
            notifyAll();
        }
        return yActual-1;
    }


    public synchronized int moveDown(int xActual, int yActual,boolean notify,int time) throws InterruptedException {
        if(warehouse[yActual+1][xActual].equals(square)){
            if(yActual+2 <= 17) {
                if (warehouse[yActual + 2][xActual].equals(square)) {
                    warehouse[yActual][xActual] = square;
                    warehouse[yActual + 1][xActual] = baixo;
                } else {
                    Thread.sleep(time);
                    warehouse[yActual][xActual] = square;
                    warehouse[yActual + 1][xActual] = baixo;
                }
            }else{
                warehouse[yActual][xActual] = square;
                warehouse[yActual + 1][xActual] = baixo;
            }
        }else if(warehouse[yActual+1][xActual].equals(cima)){
            warehouse[yActual][xActual] = wait;
            wait();
            return -1;
        }else if(warehouse[yActual+1][xActual].equals(direita) || warehouse[yActual+1][xActual].equals(esquerda) || warehouse[yActual+1][xActual].equals(baixo)){
            return -1;
        } else if(warehouse[yActual+1][xActual].equals(wait) || warehouse[yActual+1][xActual].equals(parede)){
            return yActual;
        }
        if (notify){
            notifyAll();
        }
        return yActual+1;
    }

    public synchronized void enterAgvDock(int xActual, int yActual){
        warehouse[yActual][xActual] = square;
        printMatrix();
    }

    public String printMatrix(){
        String x="";
        for (int i = 0; i < warehouse.length; i++) {
            x=x+" <br>";
            for (int j = 0; j < warehouse[i].length; j++) {
                x =x+ warehouse[i][j] + "   ";
            }
        }
        return x;
    }
}
