package com.hackerrank.data_structures.array;

import java.util.Scanner;

public class ReverseArray {

    static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0, j = array.length - 1; i < array.length; i++, j--) {
            reversedArray[j] = array[i];
        }
        return reversedArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];
        for (int i = 0; i < arrCount; i++) {
            arr[i] = Integer.parseInt(arrItems[i]);
        }
        int[] reversedArray = reverseArray(arr);
        for (int element : reversedArray) {
            System.out.print(element + " ");
        }
    }
}
