package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {

        // System.out.println(getAreaByHeron(-1,-2,-2));
       // System.out.println(Arrays.toString(getHeights(2, 3, 4)));
       // System.out.println(Arrays.toString(getMedians(4,5,6)));
        System.out.println(Arrays.toString(getBisectors(3,4,5)));
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {

        if (isWrongTriangle(a, b, c)) {
            return -1;
        }

        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {

        double[] heightsArray;
        if (isWrongTriangle(a, b, c)) {
            return new double[0];
        }

        double Area = getAreaByHeron(a, b, c);
        heightsArray = new double[3];
        heightsArray[0] = 2 * Area / a;
        heightsArray[1] = 2 * Area / b;
        heightsArray[2] = 2 * Area / c;
     // Arrays.sort(heightsArray); так конечно проще =). но допустим мы про import ничего не знаем (да мы и не знаем, IDEA сама подсказала что и как)

        return sortResult(heightsArray);
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        //        Место для вашего кода
        if (isWrongTriangle(a, b, c)) {
            return new double[0];
        }

        double[] mediansArray;
        mediansArray = new double[3];
        mediansArray[0] = Math.sqrt(2 * a * a + 2 * b * b - c * c) / 2;
        mediansArray[1] = Math.sqrt(2 * b * b + 2 * c * c - a * a) / 2;
        mediansArray[2] = Math.sqrt(2 * c * c + 2 * a * a - b * b) / 2;

        return sortResult(mediansArray);
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        //        Место для вашего кода
        if (isWrongTriangle(a, b, c)) {
            return new double[0];
        }

        double[] bisectorsArray;
        bisectorsArray = new double[3];
        bisectorsArray[0] = Math.sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b);
        bisectorsArray[1] = Math.sqrt(a * c * (a + b + c) * (a + c - b)) / (a + c);
        bisectorsArray[2] = Math.sqrt(c * b * (a + b + c) * (c + b - a)) / (c + b);

        return sortResult(bisectorsArray);
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        //        Место для вашего кода
        if (isWrongTriangle(a, b, c)) {
            return new double[0];
        }

        return null; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        //        Место для вашего кода

        if (isWrongTriangle(a, b, c)) {
            return -1;
        }

        return 0; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        //        Место для вашего кода
        if (isWrongTriangle(a, b, c)) {
            return -1;
        }

        return 0; // Заглушка. При реализации - удалить
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        //        Место для вашего кода
        if (isWrongTriangle(a, b, c)) {
            return -1;
        }

        return 0; // Заглушка. При реализации - удалить
    }

    static boolean isWrongTriangle(double a, double b, double c) {
        return (a + b <= c || a + c <= b || b + c <= a);
    }

    // сортировка из 3 чисел, без всяких пузырьков, вставок и тд
    static double[] sortResult(double[] unSortResult) {
        double [] sort;
        sort = new double[3];
        sort[0] = Math.min(Math.min(unSortResult[0], unSortResult[1]), unSortResult[2]);
        sort[2] = Math.max(Math.max(unSortResult[0], unSortResult[1]), unSortResult[2]);
        sort[1] = unSortResult[0] + unSortResult[1] + unSortResult[2] - sort[0] - sort[2];

        return sort;
    }
 }
