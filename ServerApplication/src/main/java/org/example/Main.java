package org.example;

public class Main {
    public static void main(String[] args) {
        GameServer server = new GameServer(8080);
        server.startServer();
    }
}
