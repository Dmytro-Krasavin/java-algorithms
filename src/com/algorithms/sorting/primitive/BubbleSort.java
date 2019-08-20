package com.algorithms.sorting.primitive;

import static com.algorithms.common.ArrayUtils.*;

public class BubbleSort implements SortingAlgorithm {

    @Override
    public void sort(int[] array) {
        if (array.length == 0)
            return;

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

    public static void main(String[] args) {
        int[] array = generateRandomArray(10, 100);
        SortingAlgorithm sortingAlgorithm = new BubbleSort();
        withLogging(array, sortingAlgorithm::sort);
        withStatistics(sortingAlgorithm::sort, 100000, 1000);
    }
}
