package com.data_structures.heap.generic;

public interface Heap<T extends Comparable<T>> {

    void insert(T element);

    T extractMinimal();

    int size();

}
