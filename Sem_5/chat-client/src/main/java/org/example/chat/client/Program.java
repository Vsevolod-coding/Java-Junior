package org.example.chat.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your name: ");
            String name = scanner.nextLine();
            Socket socket = new Socket("127.0.0.1", 1400);

            Client client = new Client(socket, name);

            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("InetAddress: " + inetAddress);
            String remoteIP = inetAddress.getHostAddress();
            System.out.println("RemoteIP: " + remoteIP);
            System.out.println("LocalPort: " + socket.getLocalPort());

            client.listenForMsg();
            client.sendMsg();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}