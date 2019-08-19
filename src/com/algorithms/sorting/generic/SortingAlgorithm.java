package com.algorithms.sorting.generic;

public interface SortingAlgorithm<T extends Comparable> {

    void sort(T[] array);

}
