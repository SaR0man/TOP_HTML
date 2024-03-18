package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")

public class TestController {

    // 1) Клиент отправляет число вернуть true, если оно четное в противном случае - false
    @GetMapping("/evenOdd")
    public boolean evenOdd (double value) {
        return value % 2 == 0;
    }

    // 2а) Клиент отправляет число вернуть true если оно положительное в противном случае false
    @GetMapping("/posNeg")
    public boolean posNeg (double value) {
        return value > 0;
    }

    // 2б) Клиент отправляет число вернуть true если оно делиться на 10 без остатка в противном случае false
    @GetMapping("/div10")
    public boolean div10 (double value) {
        return value % 10 == 0;
    }

    // 3) Клиент отправляет число вернуть true если оно больше числа 100 и четное в противном случае false
    @GetMapping("/posHundred")
    public boolean posHundred (double value) {
        return (value > 100 && value % 2 == 0);
    }

    // 4) Клиент отправляет число. Вернуть true если оно меньше 10, но больше 5 и делится без остатка на 3. В противном случае - false
    @GetMapping("/between5And10")
    public boolean between5And10 (double value) {
        return (value < 10 && value > 5 && value % 3 == 0);
    }

    // 5) Клиент отправляет 3 числа. Вернуть средне арифметическое
    @GetMapping("/arithmMean")
    public double arithmMean (double number1, double number2, double number3) {
        return ((number1 + number2 + number3) / 3);
    }

    // 6) Клиент отправляет Слово. Вернуть количество гласных и согласных (например, в слове "мама" 2 гласных и 2 согласных)
    @GetMapping("/vowels")
    public String result (String word) {
        String workWord = word.toLowerCase();
        String result = "В слове \"" + word + "\""; // заготовка для сообщения, передаваемого во front
        int count = 0;

        String vow = "aeiouаеёиоуыэюя"; // гласные eng и рус
        ArrayList<Character> vowels = new ArrayList<>(); // для списка гласных
        for (int i = 0; i < vow.length(); i++) { //// заполняем vowels гласными
            vowels.add(vow.charAt(i));
        }


        /*
        проверяем каждую букву переданного слова на совпадение с коллекцией гласных букв:
         */
        for (int i = 0; i < workWord.length(); i++) {
            if (vowels.contains(workWord.charAt(i)))
                count++;  // в случае совпадения увеличиваем счетчик
        }

        result += " " + count + " гласных букв и " + (word.length() - count) + " согласных букв.";

        return result;
    }

    // 7) Клиент отправляет Слово , вернуть количество символов в этом слове
    @GetMapping("/letters")
    public int letters(String word) {
        return word.length();
    }

    // 8) Клиент отправляет Предложение. Вернуть количество слов в предложении
    @GetMapping("/words")
    public int words(String sentence) {

        String[] words = sentence.split("\\s+");  // знак-разделитель - один пробел или множество

        return words.length;
    }

    // 9) Клиент отправляет Слово. Вернуть это слово наоборот
    @GetMapping("/revers")
    public String revers(String word) {
        return new StringBuilder(word).reverse().toString();  // класс StringBuilder более эффективный для работы со строками, чем String
    }

    // 10) Клиент отправляет Слово. Вернуть true если оно является палиндромом, в противном случае - false
    @GetMapping("/isPalindrome")
    public boolean isPalindrome(String str) {
        str.toLowerCase();
        String newStr = new StringBuilder(str).reverse().toString();
        return newStr.equals(str);
    }

    // 1)* Проверка на простое число: Клиент отправляет число, вернуть true, если оно является простым числом (делится только на себя и на 1), в противном случае вернуть false.
    @GetMapping("/isPrimeNumber")
    public boolean isPrimeNumber(int num) {
            if (num <= 1) return false;  // ряд простых чисел начинается с 2
            if (num == 2) return true;

            for (int i = 2; i <= Math.sqrt(num); i++) {  // достаточно проверить деление на числа от 2 до корня из переданного числа
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
    }

}
