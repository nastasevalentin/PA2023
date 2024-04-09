package org.example;

import java.awt.*;
import java.io.Serializable;

public class Stone implements Serializable {
    private Point position;
    private int width;
    private int height;
    private Color color;

    public Stone(Point position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Point getPosition() {
        return position;
    }
    public boolean contains(Point point) {
        double dx = point.x - position.x;
        double dy = point.y - position.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance <= width / 2;
    }
}
