package org.example;

import java.awt.*;
import java.io.Serializable;

public class Stick implements Serializable {
    private Point startPoint;
    private Point endPoint;

    public Stick(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }
}
