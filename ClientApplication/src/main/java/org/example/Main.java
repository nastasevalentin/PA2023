package org.example;

public class Main {
    public static void main(String[] args) {
        GameClient gameClient = new GameClient("localhost", 8080);
        gameClient.start();
    }
}