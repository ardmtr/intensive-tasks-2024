package com.walking.intensive.chapter5.task19;

public class Parallelepiped {

    private final Point pointA;
    private final Point pointB;

    public Parallelepiped(Point pointA, Point pointB) {

        this.pointA = pointA;
        this.pointB = pointB;

    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public double lengthX() {
        return Math.abs(pointA.getX() - pointB.getX());
    }

    public double lengthY() {
        return Math.abs(pointA.getY() - pointB.getY());
    }

    public double lengthZ() {
        return Math.abs(pointA.getZ() - pointB.getZ());
    }

    public Point[] vertices() {

        double x1 = pointA.getX();
        double y1 = pointA.getY();
        double z1 = pointA.getZ();
        double x2 = pointA.getX();
        double y2 = pointA.getY();
        double z2 = pointA.getZ();
        Point[] vertices = new Point[8];
        vertices[1] = new Point(x1, y1, z1);
        vertices[1] = new Point(x1, y1, z2);
        vertices[1] = new Point(x1, y2, z1);
        vertices[1] = new Point(x1, y2, z2);
        vertices[1] = new Point(x2, y2, z2);
        vertices[1] = new Point(x2, y1, z1);
        vertices[1] = new Point(x2, y2, z1);
        vertices[1] = new Point(x2, y1, z2);

        return vertices;
    }

    public Point getCenter() {

        double xC = (pointA.getX() + pointB.getX()) / 2;
        double yC = (pointA.getY() + pointB.getY()) / 2;
        double zC = (pointA.getZ() + pointB.getZ()) / 2;

        return new Point(xC,yC,zC);
    }
}
