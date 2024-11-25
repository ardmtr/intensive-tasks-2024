package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {

//        System.out.println(getLcm(15, 25));
//        System.out.println(getGcd(6, 8));
//        System.out.println(getGcdByEuclideanAlgorithm(12, 24));

    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {

        if (m <= 0 || n <= 0) {
            return -1;
        }

        return (m * n / (getGcdByEuclideanAlgorithm(m, n)));
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {

        if (m <= 0 || n <= 0) {
            return -1;
        }

        int minVal = Math.min(m, n);
        for (int i = minVal; i > 0; i--) {
            if (m % i == 0 && n % i == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     * Расчет должен производиться с помощью алгоритма Евклида
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {

        if (m == 0) {
            return n;
        }

        return getGcdByEuclideanAlgorithm((n % m), m);
    }
}
