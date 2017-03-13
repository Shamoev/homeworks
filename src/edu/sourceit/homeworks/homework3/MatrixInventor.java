package edu.sourceit.homeworks.homework3;

public class MatrixInventor {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {3, 4, 5, 6},
                {7, 5, 4, 1},
                {7, 5, 4, 1}
        };

        // we need square matrix
        for (int i = 0; i < array.length ; i++) {
            if (array[i].length != array.length) {
                System.out.println("Your matrix isn't square!");
                return;
            }
        }

        int tmp;
        for (int i = 0; i < array.length ; i++) {
            for (int j = i + 1; j < array.length ; j++) {
                tmp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = tmp;
            }
        }

        MatrixPrinter.PrintMatrix(array);

    }
}
