package org.example;

public class Tile {
    private int number1;
    private int number2;

    public Tile(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public String toString() {
        return "Tile: (" + number1 + ", " + number2 + ")";
    }
}
