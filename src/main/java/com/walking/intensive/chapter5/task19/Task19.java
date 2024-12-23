package com.walking.intensive.chapter5.task19;

//import java.util.Arrays;
import java.util.Random;

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

        Random random = new Random();
        for (int i = 0; i < 5; i++) {

            Point a = getRandomPoint();
            Point b = getRandomPoint();
            Parallelepiped parallelepiped = new Parallelepiped(a, b);
            Point c = getRandomPoint();
            int radius = random.nextInt(20);
            Sphere sphere = new Sphere(c, radius);
            System.out.println("Параллелепипед. А =" + a + ", B = " + b);
            //System.out.println(Arrays.toString(parallelepiped.vertices()));
            System.out.println("Сфера. центр = " + c + ", радиус = " + radius);
            System.out.println("пересекаются? = " + isIntersected(sphere, parallelepiped));

        }

    }

    static boolean isIntersected(Sphere sphere, Parallelepiped parallelepiped) {

        Point center = sphere.getCenter();
        double squaredRadius = Math.pow(sphere.getRadius(), 2);
        Point nearestVertex = parallelepiped.getNearestVertices(center);
        double squaredDistance = Math.pow(nearestVertex.distancePointToPoint(center), 2);

        if (sphere.containsParallelepiped(parallelepiped)) {
            return true;
        }

        if (sphere.isInsideParallelepiped(parallelepiped)) {
            return true;
        }

        return squaredDistance <= squaredRadius;
    }

    public static Point getRandomPoint() {
        Random random = new Random();
        return new Point(random.nextInt(-20, 20), random.nextInt(-20, 20), random.nextInt(-20, 20));
    }
}
