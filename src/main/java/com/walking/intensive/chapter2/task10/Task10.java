package com.walking.intensive.chapter2.task10;

/**
 * Реализуйте метод isPalindrome(), который проверяет, является ли строка палиндромом.
 *
 * <p>Метод должен игнорировать пунктуацию, пробелы и регистр.
 *
 * <p>P.S. Мой любимый палиндром: Муза! Ранясь шилом опыта, ты помолишься на разум.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task10 {
    public static void main(String[] args) {
//        String inputString = "aa   22 33 dd d А п лор Ш! ;?*( оля";
//        int length = inputString.length();
//        String normalizedString = "";
//        for (int i = 0; i < length; i++) {
//
//            if (Character.isLetter(inputString.charAt(i))) {
//                normalizedString += inputString.charAt(i);
//            }
//            System.out.println(normalizedString);
//        }
        System.out.println(isPalindrome("Муза! Ранясь шилом опыта, ты помолишься на разум."));
        System.out.println(isPalindrome("Муза!  шилом опыта, ты помолишься на разум."));
        System.out.println(isPalindrome("11222 _2211"));

    }

    static boolean isPalindrome(String inputString) {

        int length = inputString.length();

        String normalizedString = "";
        for (int i = 0; i < length; i++) {

            if (Character.isLetter(inputString.charAt(i))) {
                normalizedString += Character.toLowerCase(inputString.charAt(i));
            }
        }
//        System.out.println(normalizedString);
        length = normalizedString.length();

        if (length <= 1) {

            return false;
        }

        for (int i = 1; i < (length / 2); i++) {


            if (normalizedString.charAt(i) != normalizedString.charAt(length - i - 1)) {

                return false;
            }
        }
        return true;
    }
}
