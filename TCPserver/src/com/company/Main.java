package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {

        // call writeMessageString();
        // call picture();

    }

    public static void writeMessageString() throws Exception{
        ServerSocket ss = new ServerSocket(8000);
        while(true){
            System.out.println("Server gozleyir...");
            Socket connect = ss.accept();
            InputStream in = connect.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader bReader = new BufferedReader(reader);

            String message = bReader.readLine();
            System.out.println("netice: " + message);
        }
    }

    public static void picture() throws Exception{
        ServerSocket ss = new ServerSocket(8000);
        while(true){
            System.out.println("Server gozleyir...");
            Socket connect = ss.accept();

            DataInputStream dt = new DataInputStream(connect.getInputStream());

            byte [] arr = readMessage(dt);

            FileUtility.writeByte(arr, "java.jpg");

            InputStream in = connect.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader bReader = new BufferedReader(reader);

            String message = bReader.readLine();
            System.out.println("netice: " + message);
        }
    }

    public static byte [] readMessage(DataInputStream dis) throws IOException {
        int msgLen = dis.readInt();
        byte [] message = new byte[msgLen];
        dis.readFully(message);
        return message;

    }

}
