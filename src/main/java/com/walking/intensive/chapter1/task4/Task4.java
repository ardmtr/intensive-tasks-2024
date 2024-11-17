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

        double a = -1;
        double b = 9;
        double c = 20;

        System.out.println(solveEquation(a, b, c));

    }

    static String solveEquation(double a, double b, double c) {

        if (a == 0) {

            if (b == 0) {

                if (c == 0) {

                    return "Бесконечное множество решений.";
                } else {

                    return "Количество решений: 0.";
                }
            } else {

                double root = -c / b;

                return "Количество решений: 1. Корень: " + root;

            }
        }

        double sumOfRoots = -b / a;

        double multiplicationOfRoots = c / a;

        if (sumOfRoots == 0 && multiplicationOfRoots == 0) {

            return "Количество решений: 1. Корень: 0";

        } else if (multiplicationOfRoots == 0) {

            return "Количество решений: 2. Корни: 0;" + sumOfRoots;

        } else {

            double discriminant = sumOfRoots * sumOfRoots - 4 * multiplicationOfRoots;

            if (discriminant >= 0) {

                double sqrtDiscriminant = Math.sqrt(discriminant);

                double root1 = (sumOfRoots - sqrtDiscriminant) / 2;

                double root2 = (sumOfRoots + sqrtDiscriminant) / 2;

                if (root1 > root2) {

                    return "Количество решений: 2. Корни: " + root2+ "; " + root1;

                } else {

                    return "Количество решений: 2. Корни: " + root1 + "; " + root2;

                }

            } else {

                return "Количество решений: 0.";
            }
        }
    }
}
