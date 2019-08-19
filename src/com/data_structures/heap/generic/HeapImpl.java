package com.data_structures.heap.generic;

import com.data_structures.heap.HeapProperty;

import java.util.Arrays;
import java.util.UUID;

@SuppressWarnings({"WeakerAccess", "Duplicates"})
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

    private static final int DEFAULT_INITIAL_CAPACITY = 15;
    private static final int ROOT_INDEX = 0;

    private final HeapProperty heapProperty;
    private Object[] values;
    private int size;

    public HeapImpl(HeapProperty heapProperty) {
        this(heapProperty, DEFAULT_INITIAL_CAPACITY);
    }

    public HeapImpl(HeapProperty heapProperty, int size) {
        this.heapProperty = heapProperty;
        this.values = new Object[size];
    }

    @Override
    public void insert(T element) {
        ensureCapacity();
        int nodeIndex = getLastLeafIndex();
        values[nodeIndex] = element;
        siftUp(nodeIndex);
    }

    @Override
    public T extractMinimal() {
        T minimal = peekRoot();
        int lastLeafIndex = getLastLeafIndex();
        values[ROOT_INDEX] = values[lastLeafIndex];
        values[lastLeafIndex] = null;
        size--;
        siftDown(ROOT_INDEX);
        return minimal;
    }

    @Override
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

    @SuppressWarnings("unchecked")
    private void swapNodes(int firstIndex, int secondIndex) {
        T temp = (T) values[firstIndex];
        values[firstIndex] = values[secondIndex];
        values[secondIndex] = temp;
    }


    private boolean isNotRoot(int nodeIndex) {
        return nodeIndex != ROOT_INDEX;
    }

    private boolean isParentSatisfied(int childIndex) {
        int parentIndex = getParentIndex(childIndex);
        return isChildSatisfied(parentIndex, childIndex);
    }

    @SuppressWarnings("unchecked")
    private boolean isChildSatisfied(int parentIndex, int childIndex) {
        T parent = (T) values[parentIndex];
        T child = (T) values[childIndex];
        return childIndex >= size || heapProperty.isSatisfied(parent, child);
    }

    @SuppressWarnings("unchecked")
    private T peekRoot() {
        return (T) values[ROOT_INDEX];
    }

    private int getLastLeafIndex() {
        return size - 1;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex + 1) / 2 - 1;
    }

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
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
        Heap<UUID> heap = new HeapImpl<>(HeapProperty.MINIMUM);

        for (int i = 0; i < 10; i++) {
            heap.insert(UUID.randomUUID());
        }

        int size = heap.size();
        for (int i = 0; i < size; i++) {
            System.out.println(heap.extractMinimal());
        }
    }
}
