/*
 * Copyright (c) 2013-2022 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.example.agvdigitaltwin;




import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public final class AgvDigitalTwinApp{

    static final int SERVER_PORT = 10001;
    static final String KEYSTORE_PASS = "forgotten";

    static InetAddress serverIP;
    static SSLSocket sock;

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
//        if (args.length != 2) {
//            System.out.println("Server IPv4/IPv6 address/DNS name is required as first argument");
//            System.out.println("Client name is required as second argument (a matching keystore must exist)");
//            System.exit(1);
//        }

        // Trust these certificates provided by servers
        System.setProperty("javax.net.ssl.trustStore", args[0]+".jks");
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", args[0]+".jks");
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        String certificado=args[0];

        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            serverIP = InetAddress.getByName("localhost");
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified: " +"localhost");
            System.exit(1);
        }


        try {
            sock = (SSLSocket) sf.createSocket(serverIP, SERVER_PORT);
        } catch (IOException ex) {
            System.out.println("Failed to connect to: " + "localhost" + ":" + SERVER_PORT);
            System.out.println("Application aborted.");
            System.exit(1);
        }

        System.out.println("Connected to: " + "localhost" + ":" + SERVER_PORT);




        sock.startHandshake();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
        DataInputStream sIn = new DataInputStream(sock.getInputStream());


        String frase;
        long f, i, n, num;
        int option;
        do {
            System.out.println("Select one option:");
            System.out.println("1 -> Test request.");
            System.out.println("2 -> Disconnect.");
            System.out.println("3 -> Assign Order");
            option = scanner.nextInt();
            byte[] message = new byte[5];
            byte[] response = new byte[5];
            switch (option) {
                case 1:
                    message[0] = 1;
                    message[1] = 0;
                    message[2] = 0;
                    message[3] = 0;
                    sOut.write(message);
                    sIn.read(response);
                    if(response[1] == 2){
                        System.out.println("Test answered.");
                    }
                    break;
                case 2:
                    message[0] = 1;
                    message[1] = 1;
                    message[2] = 0;
                    message[3] = 0;
                    sOut.write(message);
                    sIn.read(response);
                    if(response[1] == 2){
                        System.out.println("Disconnecting...");
                    }
                    break;
                case 3:
                    message[0] = 1;
                    message[1] = 3;
                    message[2] = 0;
                    message[3] = 0;
                    message[4] = (byte) certificado.charAt(3);
                    sOut.write(message);
                    break;
            }
        }while(option != 2);
        sock.close();
    }
}
