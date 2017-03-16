package edu.sourceit.homeworks.homework4;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 7;

        System.out.println(fiboonacciCalc(n));
    }

    public static int fiboonacciCalc(int n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fiboonacciCalc(n - 2) + fiboonacciCalc(n - 1);
    }
}
