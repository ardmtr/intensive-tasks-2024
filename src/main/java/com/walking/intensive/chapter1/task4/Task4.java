package com.walking.intensive.chapter1.task4;

/**
 * Дано уравнение:
 *
 * <p>ax² + bx + c = 0
 *
 * <p>Реализуйте метод solveEquation(), который параметрами принимает
 * коэффициенты - вещественные числа a, b и c.
 *
 * <p>Метод должен возвращать в виде строки количество решений, а также сами решения в указанном ниже формате:
 * <ul>
 * <li> "Количество решений: 2. Корни: -4;4"
 * <li> "Количество решений: 1. Корень: 0"
 * <li> "Количество решений: 0."
 * <li> "Бесконечное множество решений."
 * </ul>
 *
 * <p>Обратите внимание, что если корней уравнения два - они должны располагаться по возрастанию.
 *
 * <p>P.S. Квадратные уравнения решаются либо через теорему Виета, либо через дискриминант.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task4 {
    public static void main(String[] args) {

        double a = 1;
        double b = 1;
        double c = -1;

        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {

        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечное множество решений.";
        }

        if (a == 0 && b == 0) {
            return "Количество решений: 0.";
        }

        if (a == 0) {
            double root = -c / b;
            return "Количество решений: 1. Корень: " + root;
        }

        double rootsSum = -b / a;
        double rootsMultiplication = c / a;
        double discriminant = rootsSum * rootsSum - 4 * rootsMultiplication;

        if (discriminant < 0) {
            return "Количество решений: 0.";
        }

        if (discriminant == 0) {
            double root = -b / (2 * a);
            return "Количество решений: 1. Корень: " + root;
        }

        double sqrtDiscriminant = Math.sqrt(discriminant);
        double root1 = (rootsSum - sqrtDiscriminant) / 2;
        double root2 = (rootsSum + sqrtDiscriminant) / 2;

        if (root1 > root2) {
            return "Количество решений: 2. Корни: " + root2 + ";" + root1;
        }
        return "Количество решений: 2. Корни: " + root1 + ";" + root2;
    }
}
