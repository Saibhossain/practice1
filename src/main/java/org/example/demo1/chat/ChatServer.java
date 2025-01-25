package org.example.demo1.chat;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private ServerSocket serverSocket;

    public void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Chat server started on port " + port);

            // Accept client connections
            Socket client1 = serverSocket.accept();
            System.out.println("Client 1 connected!");

            Socket client2 = serverSocket.accept();
            System.out.println("Client 2 connected!");

            // Start handling chat
            handleChat(client1, client2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleChat(Socket client1, Socket client2) {
        try (
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
                PrintWriter writer1 = new PrintWriter(client1.getOutputStream(), true);

                BufferedReader reader2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
                PrintWriter writer2 = new PrintWriter(client2.getOutputStream(), true)
        ) {
            // Threads for bidirectional communication
            new Thread(() -> forwardMessages(reader1, writer2, "Client 1")).start();
            new Thread(() -> forwardMessages(reader2, writer1, "Client 2")).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void forwardMessages(BufferedReader reader, PrintWriter writer, String senderName) {
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                writer.println(senderName + ": " + message);
            }
        } catch (IOException e) {
            System.out.println(senderName + " disconnected.");
        }
    }

    public void stopServer() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
                System.out.println("Server stopped.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
