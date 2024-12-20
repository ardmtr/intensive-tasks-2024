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
        double x2 = pointB.getX();
        double y2 = pointB.getY();
        double z2 = pointB.getZ();

        return new Point[]{
                new Point(Math.min(x1, x2), Math.min(y1, y2), Math.min(z1, z2)),
                new Point(Math.min(x1, x2), Math.max(y1, y2), Math.min(z1, z2)),
                new Point(Math.min(x1, x2), Math.max(y1, y2), Math.max(z1, z2)),
                new Point(Math.min(x1, x2), Math.min(y1, y2), Math.max(z1, z2)),
                new Point(Math.max(x1, x2), Math.min(y1, y2), Math.max(z1, z2)),
                new Point(Math.max(x1, x2), Math.max(y1, y2), Math.max(z1, z2)),
                new Point(Math.max(x1, x2), Math.max(y1, y2), Math.min(z1, z2)),
                new Point(Math.max(x1, x2), Math.min(y1, y2), Math.min(z1, z2))};
    }

    public Point getCenter() {

        double xC = (pointA.getX() + pointB.getX()) / 2;
        double yC = (pointA.getY() + pointB.getY()) / 2;
        double zC = (pointA.getZ() + pointB.getZ()) / 2;

        return new Point(xC, yC, zC);
    }

    public Point getNearestVertices(Point point) {

        double minDistanceToPoint = Double.MAX_VALUE;
        Point[] vertices = vertices();
        Point nearestVertex = new Point(0, 0, 0);

        for (Point vertex : vertices) {
            double d = point.distancePointToPoint(vertex);

            if (d < minDistanceToPoint) {
                minDistanceToPoint = d;
                nearestVertex = vertex;
            }
        }

        return nearestVertex;
    }


}
