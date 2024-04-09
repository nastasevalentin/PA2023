package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;
    private List<Tile> tiles = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void run() {
        while (game.isRunning()) {
            synchronized (game) {
                if(game.isTurn(this)) {
                    List<Tile> extractedTiles = game.getBag().extractTiles(1);
                    if(!extractedTiles.isEmpty()) {
                        tiles.add(extractedTiles.get(0));
                        System.out.println(name + " extracted tile: " + extractedTiles.get(0));
                        game.turn();
                    }
                }
            }
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
