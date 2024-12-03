package com.walking.intensive.chapter3.task15;

//import java.util.Arrays;

/**
 * Существует город, состоящий из N x N блоков, где каждый блок содержит одно здание в форме вертикальной
 * квадратной призмы. Линия горизонта города — это внешний контур, образованный всеми зданиями,
 * если смотреть на город издалека. Линия горизонта с каждого из сторон света — севера,
 * востока, юга и запада — может отличаться.
 *
 * <p>Каждое здание имеет определенную высоту, измеряемую в этажах.
 *
 * <p>Разрешено увеличивать высоту любого количества зданий на любую величину этажей
 * (величина может быть разной для каждого здания). Высота здания с нулевой высотой также может быть увеличена.
 * Увеличение высоты здания не должно повлиять на горизонт города ни с какой стороны света.
 *
 * <p>Реализуйте метод getMaxFloors() с учетом условий ниже.
 *
 * <p>Входящий параметр: массив city[][], где city[r][c] представляет высоту здания,
 * расположенного в блоке в строке r и столбце c. Высота здания может быть строго положительной.
 *
 * <p>Возвращаемое значение: максимально возможное количество достроенных этажей,
 * на которое можно увеличить высоту зданий без изменения горизонта города
 * с любого направления по сторонам света.
 *
 * <p>Пример:
 *
 * <p>Входящий массив: city[ ][ ] = [[2,1], [1,3]].
 *
 * <p>Возвращаемое значение: 2.
 *
 * <p>Пояснение: всего 4 здания, 2 из которых имеют по 1 этажу, 1 здание - 2 этажа и 1 здание - 3 этажа.
 * Можно добавить максимум по 1 этажу к каждому одноэтажному дому чтобы ни одна из 4 линий горизонта не поменялась.
 * Итого 2 этажа.
 *
 * <p>При наличии некорректных входных данных верните из метода -1.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task15 {
    public static void main(String[] args) {
  //      int[][] cityTest = {{3, 0, 8}, {2, 4, 7}, {2, 6, 4, 1}};

    }

    static int getMaxFloors(int[][] city) {

        if (isInvalidParams(city)) {
            return -1;
        }

        int length = city.length;
        int[] rowLimits = new int[length];
        int[] columnLimits = new int[length];
        for (int r = 0; r < rowLimits.length; r++) {
            int maxColumn = 0;
            int maxRow = 0;

            for (int c = 0; c < columnLimits.length; c++) {
                maxRow = Integer.max(maxRow, city[r][c]);
                maxColumn = Integer.max(maxColumn, city[c][r]);
            }

            rowLimits[r] = maxRow;
            columnLimits[r] = maxColumn;
        }

        int maxFloors = 0;
        for (int r = 0; r < rowLimits.length; r++) {
            for (int c = 0; c < columnLimits.length; c++) {
                int limitFloor = Math.min(columnLimits[c], rowLimits[r]);

                if (city[r][c] < limitFloor) {
                    maxFloors += limitFloor - city[r][c];
                }
            }
        }
        return maxFloors;
    }

    static boolean isInvalidParams(int[][] city) {

        if (city.length < 1) {
            return true;
        }

        for (int[] rows : city) {
            if (rows.length != city.length) {
                return true;
            }
            for (int column : rows) {
                if (column < 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
