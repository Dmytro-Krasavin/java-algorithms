package com.algorithms.sorting.generic;

import com.data_structures.heap.HeapProperty;
import com.data_structures.heap.generic.Heap;
import com.data_structures.heap.generic.HeapImpl;

import static com.algorithms.common.ArrayUtils.*;

public class Heapsort<T extends Comparable> implements SortingAlgorithm<T> {

    @Override
    @SuppressWarnings("unchecked")
    public void sort(T[] array) {
        if (array.length == 0)
            return;

        Heap heap = new HeapImpl(HeapProperty.MAXIMUM, array.length);
        for (int i = array.length - 1; i >= 0; i--) {
            heap.insert(array[i]);
        }

        int size = heap.size();
        for (int i = 0; i < size; i++) {
            T max = (T) heap.extract();
            int extractedIndex = size - i - 1;
            array[extractedIndex] = max;
        }
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(10, 100);
        SortingAlgorithm<Integer> sortingAlgorithm = new Heapsort<>();
        withLogging(toBoxed(array), sortingAlgorithm::sort);
    }
}
