package edu.sourceit.homeworks.homework4;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 7;

        System.out.println(fibonacciCalc(n));
    }

    public static int fibonacciCalc(int n) {
        if (n < 1) {
            return -1;
        }
        if (n < 3) {
            return 1;
        }
        return fibonacciCalc(n - 2) + fibonacciCalc(n - 1);
    }
}
