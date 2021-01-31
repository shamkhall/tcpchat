package com.company;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {
        // call sendMessage()
        // call sendPicture()

    }

    public static void sendMessage() throws IOException {
        Socket socket = new Socket("localhost", 8000);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        outputStream.write("Hello, Server!".getBytes(StandardCharsets.UTF_8));
        socket.close();

    }
    public static void sendPicture() throws IOException {
        Socket socket = new Socket("localhost", 8000);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        byte [] bytes = FileU.readByte("send.jpg");

        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);

        socket.close();
    }


}
