import java.util.ArrayList;
import java.util.List;

public class Crypto {
    //// заполняем словарь наиболее встречающихся символов: " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~"
    public static String alphabet() {
        String alphabet = "";
        for (int i = 32; i <= 126; i++) {
            alphabet += (char) i;
        }
        return alphabet;
    }

    //// кодируем строку original ключом key
    public static List<Integer> encrypt(String original, String key) {
        String alphabet = alphabet();  // получаем строку словаря
        List<Integer> coded = new ArrayList<>();  // заготовка возвращаемой коллекции

        for (int i = 0, y = 0; i < original.length(); i++, y++) {
//            System.out.println(alphabet.indexOf(original.charAt(i)));
            if (y == key.length()) y = 0;  // если доходим до конца key, сбрасываем индекс снова на 0
            int keyValue = alphabet.indexOf(key.charAt(y));  // получаем индекс текущего символа key в словаре alphabet
            // индекс текущего символа строки original в словаре alphabet + индекс текущего символа key в словаре alphabet
            int encryptSymbol = (alphabet.indexOf(original.charAt(i)) + keyValue);
            if (encryptSymbol >= alphabet.length()) encryptSymbol -= alphabet.length();  // индекс зашифрованного символа должен оставаться в пределах индексов словаря (сдвиг)
            coded.add(encryptSymbol);
        }
//        System.out.println(coded);

        return coded;
    }

    public static String decrypt(List<Integer> coded, String key) {
        String alphabet = alphabet();
//        List<Integer> coded = new ArrayList<>();
        String decoded = "";

        for (int i = 0, y = 0; i < coded.size(); i++, y++) {
//            System.out.println(alphabet.indexOf(original.charAt(i)));
            if (y == key.length()) y = 0;
            int keyValue = alphabet.indexOf(key.charAt(y));
            int decryptIndex = coded.get(i) - keyValue;
            if (decryptIndex < 0) decryptIndex += alphabet.length();
            decoded += alphabet.charAt(decryptIndex);
        }
//        System.out.println(coded);

        return decoded;
    }
}
