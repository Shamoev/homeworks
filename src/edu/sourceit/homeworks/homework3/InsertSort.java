package edu.sourceit.homeworks.homework3;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {

        int[] array = {5, 7, 9, 15, 10, -1, 8};

        int key;
        int j;
        for (int i = 1; i < array.length; i++) {
            key = array[i];
            j = i ;
            while (j > 0 && array[j - 1] > key) {
                array[j] = array[j - 1];
                j--;
            }
        array[j] = key;
        }

        System.out.println(Arrays.toString(array));
    }
}
