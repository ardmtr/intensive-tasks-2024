package com.walking.intensive.chapter5.task19;

import java.util.Arrays;

/**
 * Создайте классы фигур: класс сфера и параллелепипед.
 * Объект «Сфера» должен задаваться по координате точки центра
 * (x;y;z), где каждая координата задается полем класса,
 * а так же радиусом R.
 *
 * <p>Объект «Параллелепипед» должен задаваться по координате точек
 * A (x1;y1;z1) и B (x2;y2;z2), где каждая координата задается полем класса.
 * AB - главная диагональ прямоугольного параллелепипеда, а ребра параллельны базису.
 *
 * <p>Создайте в main() несколько объектов сфер и параллелепипедов и напишите метод,
 * который отвечает на вопрос: пересекается (или касается) ли объект сфера с объектом параллелепипед?
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task19 {
    public static void main(String[] args) throws Exception {
//        Для собственных проверок можете делать любые изменения в этом методе
        Point a = new Point(-2, -2, -2);
        Point b = new Point(2, 2, 2);
        Parallelepiped parallelepiped = new Parallelepiped(a, b);
        Point c = new Point(10, 100, 10);
        Sphere sphere = new Sphere(c, 1);
         System.out.println("пересекаются? = " + isIntersected(sphere, parallelepiped));
        //  System.out.println(Arrays.toString(parallelepiped.vertices()));

    }

    static boolean isIntersected(Sphere sphere, Parallelepiped parallelepiped) {

        Point center = sphere.getCenter();
        // System.out.println(center);
        double squaredRadius = Math.pow(sphere.getRadius(), 2);
        Point nearestVertex = parallelepiped.getNearestVertices(center);
        //  System.out.println(nearestVertex.toString());
        double distance = nearestVertex.distancePointToPoint(center);
        // System.out.println(distance);
        //  System.out.println(squaredRadius);
//        if (distance <= squaredRadius) {
//            return true;
//        }

        for (Point vertex : parallelepiped.vertices()) {
            distance = vertex.distancePointToPoint(center);
       //     System.out.println(distance);
       //     System.out.println(vertex);
            if (distance <= squaredRadius) {
                return true;
            }
        }

        System.out.println("пп в сфере = " + sphere.containsParallelepiped(parallelepiped));
        System.out.println("сфера в пп = " + sphere.isInsideParallelepiped(parallelepiped));
        System.out.println("расстояние меньше радиуса^2 = " + (distance <= squaredRadius));
return sphere.containsParallelepiped(parallelepiped) || sphere.isInsideParallelepiped(parallelepiped) ||
        (distance <= squaredRadius);
    }
}
