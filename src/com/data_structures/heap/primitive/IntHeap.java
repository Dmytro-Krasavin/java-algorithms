package com.data_structures.heap.primitive;

import java.util.Arrays;

@SuppressWarnings({"WeakerAccess", "Duplicates"})
public class IntHeap {

    private static final int DEFAULT_INITIAL_CAPACITY = 15;
    private static final int ROOT_INDEX = 0;

    private int[] values;
    private int size;

    public IntHeap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public IntHeap(int size) {
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
        int lastLeafIndex = getLastLeafIndex();
        values[ROOT_INDEX] = values[lastLeafIndex];
        values[lastLeafIndex] = 0;
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
            if (!isChildSatisfied(min, leftChildIndex)) {
                min = leftChildIndex;
            }
            if (!isChildSatisfied(min, rightChildIndex)) {
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
        int parent = values[nodeIndex];
        int child = values[childIndex];
        return childIndex >= size || parent <= child;
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
        IntHeap heap = new IntHeap();

        for (int i = 0; i < 10; i++) {
            heap.insert((int) (Math.random() * 100));
        }

        int size = heap.size();
        for (int i = 0; i < size; i++) {
            System.out.println(heap.extractMinimal());
        }
    }
}
