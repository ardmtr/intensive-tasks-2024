package com.walking.intensive.chapter5.task19;

public class Point {

    private final double x;
    private final double y;
    private final double z;

    public Point(double x, double y, double z) {

        this.x = x;
        this.y = y;
        this.z = z;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double distancePointToPoint(Point p) {
        return Math.sqrt(Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2) + Math.pow(p.getZ() - z, 2));
    }

}
