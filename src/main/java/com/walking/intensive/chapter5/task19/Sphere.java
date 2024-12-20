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

    public boolean isCenterInsideParallelepiped(Parallelepiped parallelepiped) {

        double x = center.getX();
        double y = center.getY();
        double z = center.getZ();
        double cx = parallelepiped.getCenter().getX();
        double cy = parallelepiped.getCenter().getY();
        double cz = parallelepiped.getCenter().getZ();
        double dx = parallelepiped.lengthX() / 2;
        double dy = parallelepiped.lengthY() / 2;
        double dz = parallelepiped.lengthZ() / 2;

        return (Math.abs(cx - x) < dx) && (Math.abs(cy - y) < dy) && (Math.abs(cz - z) < dz);
    }

    public boolean isInsideParallelepiped(Parallelepiped parallelepiped) {

        if (!isCenterInsideParallelepiped(parallelepiped)) {
            return false;
        }
        Point[] vertices = parallelepiped.vertices();

        for (Point vertex : vertices) {
            double squaredDistance = Math.pow(vertex.distancePointToPoint(center),2);

            if (squaredDistance <= Math.pow(this.getRadius(), 2)) {
                return false;
            }

        }
        return true;
    }

    public boolean containsParallelepiped(Parallelepiped parallelepiped) {

        if (!isCenterInsideParallelepiped(parallelepiped)) {
            return false;
        }

        Point[] vertices = parallelepiped.vertices();

        for (Point vertex : vertices) {
            double squaredDistance = Math.pow(vertex.distancePointToPoint(center),2);

            if (squaredDistance > Math.pow(this.getRadius(), 2)) {
                return false;
            }
        }

        return true;
    }
}
