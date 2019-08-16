package com.data_structures.heap;

import java.util.Arrays;

public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

    private static final int DEFAULT_INITIAL_CAPACITY = 20;

    private T[] values;
    private int size;

    public HeapImpl() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public HeapImpl(int size) {
        this.values = (T[]) new Object[size];
    }

    @Override
    public void insert(T element) {
        ensureCapacity();
        values[size - 1] = element;
        siftUp(size - 1);
    }

    @Override
    public T extractMinimal() {
        T minimal = peekMinimal();
        return minimal;
    }

    private void siftUp(int nodeIndex) {
        while (nodeIndex > 1 && isValid(nodeIndex)) {
            T temp = values[nodeIndex];
            values[nodeIndex] = values[nodeIndex / 2];
            values[nodeIndex / 2] = temp;

            nodeIndex = nodeIndex / 2;
        }
    }

    private void siftDown(int nodeIndex) {
        while (nodeIndex * 2 <= size) {
//            if (values[nodeIndex*2])

        }
    }

    private T peekMinimal() {
        return values[0];
    }

    private boolean isValid(int nodeIndex) {
        T element = values[nodeIndex];
        T parent = values[nodeIndex / 2];
        return element.compareTo(parent) < 0;
    }

    private void ensureCapacity() {
        size++;
        if (size > values.length) {
            int newCapacity = calculateCapacity();
            values = Arrays.copyOf(values, newCapacity);
        }
    }

    private int calculateCapacity() {
        return (int) (values.length * 1.5);
    }

    public static void main(String[] args) {

    }
}
