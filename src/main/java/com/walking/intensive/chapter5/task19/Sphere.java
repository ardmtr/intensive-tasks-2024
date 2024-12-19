package com.walking.intensive.chapter5.task19;

public class Sphere {

    final Point center;
    final double radius;

    public Sphere(Point center, double radius) throws Exception {

        if (radius < 0) {
            throw new Exception("радиус не может быть меньше 0");
        }

        this.center = center;
        this.radius = radius;

    }

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }
}
