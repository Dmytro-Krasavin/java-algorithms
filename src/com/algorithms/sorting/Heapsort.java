package com.algorithms.sorting;

import com.data_structures.heap.HeapProperty;
import com.data_structures.heap.primitive.IntHeap;

import static com.algorithms.common.ArrayUtils.generateRandomArray;
import static com.algorithms.common.ArrayUtils.print;

public class Heapsort {

    public static void sort(int[] array) {
        IntHeap heap = new IntHeap(HeapProperty.MAXIMUM, array.length);
        for (int i = array.length - 1; i >= 0; i--) {
            heap.insert(array[i]);
        }

        int size = heap.size();
        for (int i = 0; i < size; i++) {
            int max = heap.extract();
            int extractedIndex = size - i - 1;
            array[extractedIndex] = max;
        }
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(20, 100);
        print(array);
        Heapsort.sort(array);
        print(array);
    }
}
