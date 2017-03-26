package edu.sourceit.homeworks.homework3;

public class MatrixPrinter {
    public static void main(String[] args) {
        int[][] array = {
                {100, 20, 300, 4},
                {3, 41, 5, 6},
                {7, 5, -40000, 1}
        };
        PrintMatrix(array);
    }

    public static void PrintMatrix(int[][] array) {
        int max;
        for (int i = 0; i < array.length; i++) {
            max = array[i].length - 1;
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < findMaxNumberOfSymbolsInRow(array, j) + 2 - calcNumberOfSymbols(array[i][j]); k++) {
                    System.out.print(" ");
                }
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    // calc number of digits in integer plus '-'
    private static int calcNumberOfSymbols(int number) {
        return Integer.toString(number).length();
    }

    private static int findMaxNumberOfSymbolsInRow(int[][] array, int row) {
        int maxNumberOfSymbolsInRow= 0;
        int n;
        for (int i = 0; i < array.length; i++) {
            n = calcNumberOfSymbols(array[i][row]);
            if (n > maxNumberOfSymbolsInRow) {
                maxNumberOfSymbolsInRow = n;
            }
        }
        return maxNumberOfSymbolsInRow;
    }
}

