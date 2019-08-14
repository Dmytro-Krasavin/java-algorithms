package com.algorithms.sorting;

import static com.algorithms.common.ArrayUtils.generateRandomArray;
import static com.algorithms.common.ArrayUtils.withProfiling;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = generateRandomArray(10, 100);
        withProfiling(array, BubbleSort::bubbleSort);
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int current = array[j];
                int next = array[j + 1];
                if (current > next) {
                    array[j] = next;
                    array[j + 1] = current;
                }
            }
        }
    }
}
