package com.hackerrank.data_structures.array;

import java.util.Arrays;
import java.util.Scanner;

public class LeftRotation {

    private static final Scanner scanner = new Scanner(System.in);

    private static void rotate(int[] array, int rotationCount) {
        int[] oldArray = Arrays.copyOf(array, array.length);

        for (int i = 0; i < array.length; i++) {
            int rotatedIndex = i - rotationCount;
            if (rotatedIndex < 0) {
                rotatedIndex = array.length + rotatedIndex;
            }

            array[rotatedIndex] = oldArray[i];
        }
    }

    public static void main(String[] args) {
        String[] countsInput = scanner.nextLine().split(" ");
        int length = Integer.parseInt(countsInput[0]);
        int rotationCount = Integer.parseInt(countsInput[1]);
        int[] array = new int[length];

        String[] items = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < length; i++) {
            int aItem = Integer.parseInt(items[i]);
            array[i] = aItem;
        }

        rotate(array, rotationCount);
        for (int element : array) {
            System.out.print(element + " ");
        }

        scanner.close();
    }
}
