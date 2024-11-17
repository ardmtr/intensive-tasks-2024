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
//        Для собственных проверок можете делать любые изменения в этом методе
        double a = 1;
        double b = -8;
        double c = 15;

        System.out.println(solveEquation(a, b, c));

    }

    static String solveEquation(double a, double b, double c) {
        //        Место для вашего кода

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

        double productOfRoots = c / a;

        if (sumOfRoots == 0 && productOfRoots == 0) {

            return "Количество решений: 1. Корень: 0";

        } else if (productOfRoots == 0) {

            double nonZeroRoot = sumOfRoots;

            return "Количество решений: 2. Корни: 0;" + nonZeroRoot;

        } else {

            double discriminant = sumOfRoots * sumOfRoots - 4 * productOfRoots;

            if (discriminant >= 0) {

            }
                double sqrtDiscriminant = Math.sqrt(discriminant);

                double root1 = (sumOfRoots - sqrtDiscriminant) / 2;

                double root2 = (sumOfRoots + sqrtDiscriminant) / 2;

                if (root1 > root2) {

                    double temp = root1;

                    root1 = root2;

                    root2 = temp;

                }

                return "Количество решений: 2. Корни: " + root1 + ";" + root2;

            } else {

                return "Количество решений: 0.";
            }
        }
    }
