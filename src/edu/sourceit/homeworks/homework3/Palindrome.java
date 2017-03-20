package edu.sourceit.homeworks.homework3;

import java.lang.reflect.Array;

public class Palindrome {
    public static void main(String[] args) {
        int n = 1234321;
        String str = Integer.toString(n);
        String[] strArr = str.split("");
        int[] array = new int[str.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strArr[i]);
            // System.out.println(array[i]);
        }
        for (int i = 0; i < array.length / 2 ; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                System.out.println("no!");
                return;
            }
        }
        System.out.println("yes");
    }


}
