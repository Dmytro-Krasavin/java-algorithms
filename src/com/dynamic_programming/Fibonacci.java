package com.dynamic_programming;

public class Fibonacci {

    public static long fibonacci(int n) {
        long prev = 0, next = 1;
        for (int i = 0; i < n; i++) {
            long temp = next;
            next = prev + next;
            prev = temp;
        }
        return prev;
    }

    public static long recursiveFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static long memoizeFibonacci(int n) {
        long[] fibonacci = new long[n];
        fibonacci[0] = fibonacci[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[n - 1];
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        long fibonacci = fibonacci(120);
        System.out.println(System.nanoTime() - start);
        System.out.println(fibonacci);
    }
}
