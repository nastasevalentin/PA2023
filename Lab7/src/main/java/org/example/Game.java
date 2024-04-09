package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag;
    private final List<Player> players;
    private boolean running = true;
    private int playerIndex = 0;

    public Game(int n) {
        this.bag = new Bag(n);
        players = new ArrayList<>();
    }
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    public void play() {
        for (Player player : players) {
            Thread thread = new Thread(player);
            thread.start();

        }
    }
    public synchronized boolean isTurn(Player player) {
        return players.indexOf(player) == playerIndex;
    }
    public synchronized void turn() {
        if(bag.getTiles().isEmpty()) {
            running = false;
        } else {
            playerIndex++;
            playerIndex = playerIndex % players.size();
        }
    }

    public synchronized void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isRunning() {
        return running;
    }

    public Bag getBag() {
        return bag;
    }
}
