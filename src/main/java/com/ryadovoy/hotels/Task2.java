package com.ryadovoy.hotels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(42, 12, 18);
        List<Integer> divisors = findCommonDivisors(numbers);
        System.out.println(divisors);
    }

    private static List<Integer> findCommonDivisors(List<Integer> numbers) {
        // возвращаем пустой массив, если в массиве нет чисел
        if (numbers == null || numbers.isEmpty()) {
            return Collections.emptyList();
        }

        // проверки на отрицательные числа нет, потому что вернется пустой массив

        // находим наименьшее число в массиве, чтобы ограничить количество проверяемых делителей
        int minNumber = Collections.min(numbers);

        List<Integer> commonDivisors = new ArrayList<>();

        // начинаем с двух, потому что в примере из задания единица не добавляется (как само собой разумеющееся)
        for (int divisor = 2; divisor <= minNumber; divisor++) {
            boolean isCommonDivisor = true;

            // проверяем, является ли делитель общим для всех чисел
            for (int number : numbers) {
                if (number % divisor != 0) {
                    isCommonDivisor = false;
                    break;
                }
            }

            if (isCommonDivisor) {
                commonDivisors.add(divisor);
            }
        }

        return commonDivisors;
    }
}
