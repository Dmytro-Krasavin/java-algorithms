package com.data_structures.queue;

import com.data_structures.heap.generic.Heap;
import com.data_structures.heap.generic.HeapImpl;

import java.util.UUID;

public class PriorityQueue<T extends Comparable<T>> {

    private final Heap<T> heap;

    public PriorityQueue(Class<T> type) {
        heap = new HeapImpl<>(type);
    }

    public PriorityQueue(int size, Class<T> type) {
        heap = new HeapImpl<>(size, type);
    }

    public void insert(T element) {
        heap.insert(element);
    }

    public T extractMinimal() {
        return heap.extractMinimal();
    }

    public int size() {
        return heap.size();
    }

    public static void main(String[] args) {
        PriorityQueue<UUID> queue = new PriorityQueue<>(UUID.class);

        for (int i = 0; i < 10; i++) {
            queue.insert(UUID.randomUUID());
        }

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.extractMinimal());
        }
    }
}
