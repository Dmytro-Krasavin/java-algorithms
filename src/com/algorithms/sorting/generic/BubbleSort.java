package com.algorithms.sorting.generic;

import static com.algorithms.common.ArrayUtils.*;

public class BubbleSort<T extends Comparable> implements SortingAlgorithm<T> {

    @Override
    @SuppressWarnings("unchecked")
    public void sort(T[] array) {
        if (array.length == 0)
            return;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                T current = array[j];
                T next = array[j + 1];
                if (current.compareTo(next) > 0) {
                    array[j] = next;
                    array[j + 1] = current;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(10, 100);
        SortingAlgorithm<Integer> sortingAlgorithm = new BubbleSort<>();
        withLogging(toBoxed(array), sortingAlgorithm::sort);
        withStatisticsBoxed(sortingAlgorithm::sort, 100000, 1000);
    }
}
