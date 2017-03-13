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
        // first size (m x n1)
        int m = first.length;
        int n1 =first[0].length;
        // second size (n2 x k)
        int n2 = second.length;
        int k = second[0].length;

        // n1 = n2
        if (n1 != n2) {
            System.out.println("Number of columns in the first matrix must be equal number of rows in the second matrix.");
            return;
        }

        int[][] product = new int[m][k];
        int sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                sum = 0;
                for (int g = 0; g < n1; g++) {
                    sum += (first[i][g] * second[g][j]);
                }
                product[i][j] = sum;
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
