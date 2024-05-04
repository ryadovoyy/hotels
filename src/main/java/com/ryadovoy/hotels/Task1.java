package com.ryadovoy.hotels;

public class Task1 {
    public static void main(String[] args) {
        String computerSentence = countComputers(25);
        System.out.println(computerSentence);
    }

    private static String countComputers(int number) {
        // при получении склонения в зависимости от числительного используются 3 формы слова
        String computerWord = deduceDeclension(number, "компьютер", "компьютера", "компьютеров");
        return number + " " + computerWord;
    }

    private static String deduceDeclension(int number, String form1, String form2, String form5) {
        // находим модуль числа
        number = Math.abs(number);

        // получаем две последние цифры числа
        int lastDigit = number % 10;
        int lastTwoDigits = number % 100;

        // выбираем склонение в зависимости от последних цифр
        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            return form5;
        }
        if (lastDigit == 1) {
            return form1;
        }
        if (lastDigit >= 2 && lastDigit <= 4) {
            return form2;
        }
        return form5;
    }
}
