package com.data_structures.queue;

import com.data_structures.heap.generic.Heap;
import com.data_structures.heap.generic.HeapImpl;

public class PriorityQueue<T extends Comparable> {

    private final Heap heap;

    public PriorityQueue(Class<T> type) {
        heap = new HeapImpl(type);
    }

    public PriorityQueue(int size, Class<T> type) {
        heap = new HeapImpl(size, type);
    }

    public static void main(String[] args) {

    }
}
