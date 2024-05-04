package com.ryadovoy.hotels;

public class Task4 {
    public static void main(String[] args) {
        try {
            printMultiplicationTable(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printMultiplicationTable(int size) {
        // проверяем, что размер таблицы больше 0
        if (size < 1) {
            throw new IllegalArgumentException("The size of the multiplication table must be greater than 0");
        }

        // объявляем переменную строки таблицы
        StringBuilder row = new StringBuilder();

        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                int cellNumber;
                int cellWidth;

                // ширина клетки в таблице вычисляется на основе максимальной длины числа в столбце
                if (j == 0) {
                    cellWidth = countDigits(size);
                } else {
                    cellWidth = countDigits(size * j);
                }

                // получаем число в клетке
                if (i == 0 || j == 0) {
                    if (i == 0 && j == 0) {
                        // пустая клетка в левом верхнем углу
                        row.append(" ".repeat(cellWidth + 1));
                        continue;
                    } else if (i == 0) {
                        cellNumber = j;
                    } else {
                        cellNumber = i;
                    }
                } else {
                    cellNumber = i * j;
                }

                // выравниваем числа по правой стороне клетки
                String cell = String.format("%" + cellWidth + "d", cellNumber);
                row.append(cell);

                // добавляем пробел между клетками
                if (j < size) {
                    row.append(" ");
                }
            }

            // выводим строку таблицы в консоль и обнуляем переменную строки
            System.out.println(row);
            row.setLength(0);
        }
    }

    private static int countDigits(int number) {
        return (int) (Math.log10(number) + 1);
    }
}
