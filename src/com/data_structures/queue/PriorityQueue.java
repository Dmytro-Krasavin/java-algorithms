package com.data_structures.queue;

import com.data_structures.heap.HeapProperty;
import com.data_structures.heap.generic.Heap;
import com.data_structures.heap.generic.HeapImpl;

import java.util.UUID;

public class PriorityQueue<T extends Comparable<T>> {

    private final Heap<T> heap;

    public PriorityQueue(HeapProperty heapProperty) {
        heap = new HeapImpl<>(heapProperty);
    }

    public PriorityQueue(HeapProperty heapProperty, int size) {
        heap = new HeapImpl<>(heapProperty, size);
    }

    public void insert(T element) {
        heap.insert(element);
    }

    public T extract() {
        return heap.extract();
    }

    public int size() {
        return heap.size();
    }

    public static void main(String[] args) {
        PriorityQueue<UUID> queue = new PriorityQueue<>(HeapProperty.MAXIMUM);

        for (int i = 0; i < 10; i++) {
            queue.insert(UUID.randomUUID());
        }

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.extract());
        }
    }
}
