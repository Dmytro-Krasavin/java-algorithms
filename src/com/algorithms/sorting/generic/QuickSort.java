package com.algorithms.sorting.generic;

import static com.algorithms.common.ArrayUtils.*;

public class QuickSort<T extends Comparable> implements SortingAlgorithm<T> {

    @Override
    public void sort(T[] array) {
        if (array.length == 0)
            return;

        sort(array, 0, array.length - 1);
    }

    @SuppressWarnings("unchecked")
    private void sort(T[] array, int start, int end) {
        if (start >= end)
            return;

        T x = array[createRandomIntBetween(start, end)];
        int i = start;
        int j = end;
        while (i < j) {
            while (array[i].compareTo(x) < 0)
                i++;
            while (array[j].compareTo(x) > 0)
                j--;
            if (i <= j) {
                swapNodes(array, i, j);
                i++;
                j--;
            }
        }
        if (start < j)
            sort(array, start, j);
        if (i < end)
            sort(array, i, end);
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(10, 100);
        SortingAlgorithm<Integer> sortingAlgorithm = new QuickSort<>();
        withLogging(toBoxed(array), sortingAlgorithm::sort);
    }
}
