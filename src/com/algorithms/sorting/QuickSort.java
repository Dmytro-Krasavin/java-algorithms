package com.algorithms.sorting;

import static com.algorithms.common.ArrayUtils.*;

public class QuickSort {

    public static void sort(int[] array) {
        if (array.length == 0)
            return;

        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        if (start >= end)
            return;

        int x = array[createRandomIntBetween(start, end)];
        int i = start;
        int j = end;
        while (i < j) {
            while (array[i] < x) {
                i++;
            }
            while (array[j] > x) {
                j--;
            }
            if (i <= j) {
                swapNodes(array, i, j);
                i++;
                j--;
            }
        }

        if (start < j) {
            sort(array, start, j);
        }
        if (i < end) {
            sort(array, i, end);
        }
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(20, 100);
        print(array);
        QuickSort.sort(array);
        print(array);
    }
}
