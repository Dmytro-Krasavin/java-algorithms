package com.data_structures.heap.primitive;

import java.util.Arrays;

public class Heap {

    private static final int DEFAULT_INITIAL_CAPACITY = 15;
    private static final int ROOT_INDEX = 0;

    private int[] values;
    private int size;

    public Heap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public Heap(int size) {
        this.values = new int[size];
    }

    public void insert(int node) {
        ensureCapacity();
        int nodeIndex = getLastLeafIndex();
        values[nodeIndex] = node;
        siftUp(nodeIndex);
    }

    public int extractMinimal() {
        int minimal = peekRoot();
        values[ROOT_INDEX] = values[getLastLeafIndex()];
        size--;
        siftDown(ROOT_INDEX);
        return minimal;
    }

    public int size() {
        return size;
    }

    public void trimToSize() {
        if (size < values.length) {
            values = Arrays.copyOf(values, size);
        }
    }

    private void siftUp(int nodeIndex) {
        while (isNotRoot(nodeIndex) && !isParentSatisfied(nodeIndex)) {
            int parentIndex = getParentIndex(nodeIndex);
            swapNodes(nodeIndex, parentIndex);
            nodeIndex = parentIndex;
        }
    }

    private void siftDown(int nodeIndex) {
        while (getLeftChildIndex(nodeIndex) < size) {
            int leftChildIndex = getLeftChildIndex(nodeIndex);
            int rightChildIndex = getRightChildIndex(nodeIndex);

            int min = nodeIndex;
            if (isChildSatisfied(min, leftChildIndex)) {
                min = leftChildIndex;
            }
            if (isChildSatisfied(min, rightChildIndex)) {
                min = rightChildIndex;
            }

            if (min == nodeIndex) break;
            swapNodes(nodeIndex, min);
            nodeIndex = min;
        }
    }

    private void swapNodes(int firstIndex, int secondIndex) {
        int temp = values[firstIndex];
        values[firstIndex] = values[secondIndex];
        values[secondIndex] = temp;
    }


    private boolean isNotRoot(int nodeIndex) {
        return nodeIndex != ROOT_INDEX;
    }

    private boolean isParentSatisfied(int nodeIndex) {
        int parentIndex = getParentIndex(nodeIndex);
        return values[nodeIndex] >= values[parentIndex];
    }

    private boolean isChildSatisfied(int nodeIndex, int childIndex) {
        return childIndex >= size || values[nodeIndex] >= values[childIndex];
    }


    private int peekRoot() {
        return values[ROOT_INDEX];
    }

    private int getLastLeafIndex() {
        return size - 1;
    }

    private int getParentIndex(int nodeIndex) {
        return (nodeIndex + 1) / 2 - 1;
    }

    private int getLeftChildIndex(int nodeIndex) {
        return nodeIndex * 2 + 1;
    }

    private int getRightChildIndex(int nodeIndex) {
        return nodeIndex * 2 + 2;
    }


    private void ensureCapacity() {
        size++;
        int currentCapacity = values.length;
        if (size > currentCapacity) {
            int newCapacity = currentCapacity * 2 + 1;
            values = Arrays.copyOf(values, newCapacity);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();

        int[] array = {54, 30, 45, 60, 78, 90, 25, 10, 34, 88, 50, 17};

        for (int element : array) {
            heap.insert(element);
        }

//        for (int i = 0; i < 10; i++) {
//            heap.insert((int) (Math.random() * 100));
//        }

        int size = heap.size();
        for (int i = 0; i < size; i++) {
            System.out.println(heap.extractMinimal());
        }

        System.out.println();
    }
}
