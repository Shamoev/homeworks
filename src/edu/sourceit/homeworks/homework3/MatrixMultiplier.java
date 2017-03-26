package edu.sourceit.homeworks.homework3;

public class MatrixMultiplier {
    public static void main(String[] args) {
        int[][] first = {
                {1, 2, 3, 4},
                {3, 4, 5, 6},
                {7, 5, 4, 1}
        };

        int[][] second = {
                {1, 2, 3},
                {3, 4, 6},
                {7, 5, 1},
                {3, 4, 6}
        };

        if (!isMatrixRectangular(first) || !isMatrixRectangular(second)) {
            System.out.println("Matrices should be rectangular.");
            return;
        }
        // first size
        int firstMatrixNumOfRows = first.length;
        int firstMatrixNumOfColumns =first[0].length;
        // second size
        int secondMatrixNumOfRows = second.length;
        int secondMatrixNumOfColumns = second[0].length;

        // check the rule for matrix multiplication
        if (firstMatrixNumOfColumns != secondMatrixNumOfRows) {
            System.out.println("Number of columns in the first matrix must be equal number of rows in the second matrix.");
            return;
        }

        int[][] product = new int[firstMatrixNumOfRows][secondMatrixNumOfColumns];

        for (int i = 0; i < firstMatrixNumOfRows; i++) {
            for (int j = 0; j < secondMatrixNumOfColumns; j++) {
                for (int g = 0; g < firstMatrixNumOfColumns; g++) {
                    product[i][j] += (first[i][g] * second[g][j]);
                }
            }
        }
        MatrixPrinter.PrintMatrix(product);
    }

    public static boolean isMatrixRectangular(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            if (matrix[i].length != m) {
                return  false;
            }
        }
        return true;
    }
}
