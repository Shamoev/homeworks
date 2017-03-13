package edu.sourceit.homeworks.homework2;

public class ArrayToString {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i == array.length - 1) {
                System.out.print("]");
                break;
            }
            System.out.print(", ");
        }
    }
}
