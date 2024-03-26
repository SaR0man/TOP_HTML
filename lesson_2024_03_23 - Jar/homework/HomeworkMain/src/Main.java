import java.util.List;

public class Main {
    public static void main(String[] args) {
        //// Входные данные, можно менять. Используются цифры, латинский алфавит и знаки препинания:
        String originalText = "I'll learn Java to change the World!";
        String key = "crypto";

        //// Основной алгоритм:
        System.out.println("=====================================================================================");
        System.out.println("Шифр Виженера — метод полиалфавитного шифрования буквенного текста с использованием ключевого слова.");
        System.out.println("На протяжении трех столетий он противостоял всем попыткам его взломать, благодаря чему его называли «неразгаданным шифром».");
        System.out.println("=====================================================================================");
        System.out.println("Оригинальная фраза: \"" + originalText + "\", кодировать ключом: " + key);
        List<Integer> coded = (Crypto.encrypt(originalText, key));
        System.out.println("В закодированном виде: " + coded);
        System.out.println("В раскодированном виде: " + Crypto.decrypt(coded, key));
    }
}