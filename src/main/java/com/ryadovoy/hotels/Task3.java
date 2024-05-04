package com.ryadovoy.hotels;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        try {
            List<Integer> primes = findPrimesInRange(11, 20);
            System.out.println(primes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Integer> findPrimesInRange(int min, int max) {
        // проверяем, что максимальное значение в диапазоне не меньше минимального
        if (min > max) {
            throw new IllegalArgumentException("The last number in the range is less than the first");
        }

        List<Integer> primes = new ArrayList<>();

        // находим простые числа в диапазоне
        for (int number = min; number <= max; number++) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }

        return primes;
    }

    private static boolean isPrime(int number) {
        // числа меньше 2 не являются простыми
        if (number <= 1) {
            return false;
        }

        // используем квадратный корень для оптимизации нахождения простых чисел
        for (int i = 2; i <= Math.sqrt(number); i++) {
            // если число имеет делители помимо 1 и самого себя, то оно не является простым
            if (number % i == 0) {
                return false;
            }
        }

        // если предыдущие проверки не сработали, значит число простое
        return true;
    }
}
