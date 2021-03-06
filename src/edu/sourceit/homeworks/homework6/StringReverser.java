package edu.sourceit.homeworks.homework6;

public class StringReverser {
    public static void main(String[] args) {
        String string = "abcdef";
        System.out.println(stringReverse(string));
    }

    public static String stringReverse(String string) {
        if (string == null || string.length() < 2) {
            return string;
        }
        char[] chars = string.toCharArray();

        char tmp;
        for (int i = 0; i < chars.length / 2; i++) {
            tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        return new String(chars);
    }
}
