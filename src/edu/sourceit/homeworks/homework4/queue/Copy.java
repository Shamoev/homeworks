package edu.sourceit.homeworks.homework4.queue;

import java.util.Arrays;

/**
 * Created by Саша on 24.03.2017.
 */
public class Copy {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5};
        System.arraycopy(array, 0, array, 1, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
