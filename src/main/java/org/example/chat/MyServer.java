package org.example.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MyServer {

    public static final int MY_SERVER_PORT = 54325;
    public static final Charset MY_COMM_CHARSET = StandardCharsets.UTF_8;
    public static final String BYE = "bye";

    public static void main(String[] args) {
        commWithClient();
    }

    private static void commWithClient() {
        try (
                ServerSocket ss = new ServerSocket(MY_SERVER_PORT);
                Socket s = ss.accept();
        ) {
            MyChat myChat = new MyChat("客户端", "你已经连接上服务器端了", s);
            myChat.chatting();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
