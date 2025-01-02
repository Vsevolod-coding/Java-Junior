package org.example.chat.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {
    private final Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String name;

    public static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        this.socket = socket;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            System.out.println(name + " joined the chat.");
            broadcastMsg("Server: " + name + " joined the chat.");
        }
        catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClient();
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void removeClient() {
        clients.remove(this);
        System.out.println(name + " left the chat.");
        broadcastMsg("Server: " + name + " left the chat.");
    }

    @Override
    public void run() {
        String msgFromClient;
        while (socket.isConnected()) {
            try {
                msgFromClient = bufferedReader.readLine();

                // Check if message starts with "@"
                if (msgFromClient.startsWith("@")) {
                    int spaceIndex = msgFromClient.indexOf(" ");
                    if (spaceIndex > 1) {
                        String recipientName = msgFromClient.substring(1, spaceIndex).trim();
                        String message = msgFromClient.substring(spaceIndex + 1).trim();
                        sendPrivateMessage(recipientName, message);
                    } else {
                        broadcastMsg(name + ": " + msgFromClient);
                    }
                } else {
                    broadcastMsg(name + ": " + msgFromClient);
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private void sendPrivateMessage(String recipientName, String msg) {
        boolean userFound = false;

        for (ClientManager client : clients) {
            if (client.name.equals(recipientName)) {
                try {
                    client.bufferedWriter.write("DM from " + name + ": " + msg);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                    userFound = true;
                    break;
                }
                catch (IOException e) {
                    closeEverything(socket, bufferedReader, bufferedWriter);
                }
            }
        }

        if (!userFound) {
            broadcastMsg(name + ": @" + recipientName + " " + msg);
        }
    }

    private void broadcastMsg(String msg) {
        for (ClientManager client : clients) {
            if (!client.name.equals(name)) {
                try {
                    client.bufferedWriter.write(msg);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                } catch (IOException e) {
                    closeEverything(socket, bufferedReader, bufferedWriter);
                }
            }
        }
    }
}
