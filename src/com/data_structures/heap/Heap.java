package com.data_structures.heap;

public interface Heap<T extends Comparable<T>> {

    void insert(T element);

    T extractMinimal();

}
