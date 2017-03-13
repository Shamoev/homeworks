package edu.sourceit.homeworks.homework3;

public class MatrixPrinter {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {3, 4, 5, 6},
                {7, 5, 4, 1}
        };
        PrintMatrix(array);
    }

    public static void PrintMatrix(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

