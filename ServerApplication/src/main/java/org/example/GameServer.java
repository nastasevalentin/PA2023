package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private ServerSocket serverSocket;
    private boolean isRunning;

    public GameServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            isRunning = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        while (isRunning) {
            try {
                System.out.println("Waiting for client...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                new ClientThread(clientSocket, this).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopServer() {
        isRunning = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isRunning() {
        return isRunning;
    }
}