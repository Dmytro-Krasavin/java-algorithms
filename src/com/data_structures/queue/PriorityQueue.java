package com.data_structures.queue;

import com.data_structures.heap.generic.Heap;
import com.data_structures.heap.generic.HeapImpl;

public class PriorityQueue {

    private final Heap heap;

    public PriorityQueue() {
        heap = new HeapImpl();
    }

    public PriorityQueue(int size) {
        heap = new HeapImpl(size);
    }

    public static void main(String[] args) {

    }
}
