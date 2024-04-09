package org.example;

import java.awt.*;
import java.io.Serializable;
import java.util.*;
import java.util.List;

public class Game implements Serializable {
    private DrawingPanel drawingPanel;
    private List<Stick> sticks;
    private List<Stone> stones;
    private Stone lastStone;
    private boolean player1;
    private Map<Stone, Color> coloredStones;

    public Game(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
        this.sticks = drawingPanel.getGeneratedSticks();
        this.stones = drawingPanel.getAvailableStones();
        this.coloredStones = new HashMap<>();
        this.player1 = true;
        lastStone = new Stone(new Point(-1, -1), 0, 0);
    }
    public boolean isAvailable(Point point) {
        for (Stone stone : stones) {
            if (stone.contains(point)) {
                if (lastStone.getPosition().x == -1) {
                    lastStone = stone;
                    stones.remove(stone);
                    if(player1) {
                        coloredStones.put(stone, Color.RED);
                    } else {
                        coloredStones.put(stone, Color.BLUE);
                    }
                    return true;
                } else {
                    if (lastStone.getPosition().x == stone.getPosition().x && lastStone.getPosition().y == stone.getPosition().y + drawingPanel.getCellHeight()) {
                        if(isStickBetween(lastStone, stone)) {
                            lastStone = stone;
                            stones.remove(stone);
                            if(player1) {
                                coloredStones.put(stone, Color.RED);
                            } else {
                                coloredStones.put(stone, Color.BLUE);
                            }
                            return true;
                        }

                    } else if (lastStone.getPosition().x == stone.getPosition().x && lastStone.getPosition().y == stone.getPosition().y - drawingPanel.getCellHeight()) {
                        if(isStickBetween(lastStone, stone)) {
                            lastStone = stone;
                            stones.remove(stone);
                            if(player1) {
                                coloredStones.put(stone, Color.RED);
                            } else {
                                coloredStones.put(stone, Color.BLUE);
                            }
                            return true;
                        }
                    } else if (lastStone.getPosition().x == stone.getPosition().x + drawingPanel.getCellWidth() && lastStone.getPosition().y == stone.getPosition().y) {
                        if (isStickBetween(lastStone, stone)) {
                            lastStone = stone;
                            stones.remove(stone);
                            if(player1) {
                                coloredStones.put(stone, Color.RED);
                            } else {
                                coloredStones.put(stone, Color.BLUE);
                            }
                            return true;
                        }
                    } else if (lastStone.getPosition().x == stone.getPosition().x - drawingPanel.getCellWidth() && lastStone.getPosition().y == stone.getPosition().y) {
                        if (isStickBetween(lastStone, stone)) {
                            lastStone = stone;
                            stones.remove(stone);
                            if(player1) {
                                coloredStones.put(stone, Color.RED);
                            } else {
                                coloredStones.put(stone, Color.BLUE);
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isPlayer1() {
        return player1;
    }

    public void setPlayer1(boolean player1) {
        this.player1 = player1;
    }
    public void reset() {
        this.player1 = true;
        this.lastStone = new Stone(new Point(-1, -1), 20, 20);
        this.stones = drawingPanel.getAvailableStones();
        this.coloredStones.clear();
    }
    public int countNeighbors() {
        if(lastStone.getPosition().x == -1) {
            return 4;
        }
        int count = 0;
        for(var i : stones) {
            if(lastStone.getPosition().x == i.getPosition().x && lastStone.getPosition().y == i.getPosition().y + drawingPanel.getCellHeight()) {
                if (isStickBetween(lastStone, i)) {
                    count++;
                }
            } else if (lastStone.getPosition().x == i.getPosition().x && lastStone.getPosition().y == i.getPosition().y - drawingPanel.getCellHeight()) {
                if (isStickBetween(lastStone, i)) {
                    count++;
                }
            } else if (lastStone.getPosition().x == i.getPosition().x + drawingPanel.getCellWidth() && lastStone.getPosition().y == i.getPosition().y) {
                if (isStickBetween(lastStone, i)) {
                    count++;
                }
            } else if (lastStone.getPosition().x == i.getPosition().x - drawingPanel.getCellWidth() && lastStone.getPosition().y == i.getPosition().y) {
                if (isStickBetween(lastStone, i)) {
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isStickBetween(Stone stone1, Stone stone2) {
        for (Stick stick : sticks) {
            if ((stick.getStartPoint().equals(stone1.getPosition()) && stick.getEndPoint().equals(stone2.getPosition())) ||
                    (stick.getStartPoint().equals(stone2.getPosition()) && stick.getEndPoint().equals(stone1.getPosition()))) {
                return true;
            }
        }
        return false;
    }
    public Map<Stone, Color> getColoredStones() {
        return coloredStones;
    }

    public List<Stick> getSticks() {
        return sticks;
    }
}
