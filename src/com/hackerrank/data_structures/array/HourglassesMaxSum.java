package com.hackerrank.data_structures.array;

import java.util.Scanner;

public class HourglassesMaxSum {

    static int hourglassMaxSum(int[][] array) {
        int[] hourglassArray = new int[16];
        int hourglassCount = 0;
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = 0; j < array[i].length - 2; j++) {
                int hourglass = array[i][j] + array[i][j + 1] + array[i][j + 2]
                        + array[i + 1][j + 1]
                        + array[i + 2][j] + array[i + 2][j + 1] + array[i + 2][j + 2];
                hourglassArray[hourglassCount++] = hourglass;
            }
        }
        int maxHourglass = Integer.MIN_VALUE;
        for (int hourglass : hourglassArray) {
            if (hourglass > maxHourglass) maxHourglass = hourglass;
        }
        return maxHourglass;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] array = new int[6][6];
        for (int i = 0; i < array.length; i++) {
            String[] arrayRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < array[i].length; j++) {
                int arrayItem = Integer.parseInt(arrayRowItems[j]);
                array[i][j] = arrayItem;
            }
        }

        int result = hourglassMaxSum(array);
        System.out.println(result);
        scanner.close();
    }
}
