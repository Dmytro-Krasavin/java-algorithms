package com.hackerrank.data_structures.heap;

import java.util.Scanner;

public class QueryHeap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());
        Heap heap = new Heap(queriesCount);
//        PriorityQueue<Integer> heap = new PriorityQueue<>(queriesCount);

        String[] queries = new String[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            queries[i] = scanner.nextLine().trim();
        }

        for (String query : queries) {
            String[] strings = query.split(" ");
            String queryId = strings[0];
            switch (queryId) {
                case "1":
                    heap.add(Integer.parseInt(strings[1]));
                    break;
                case "2":
                    heap.remove(Integer.parseInt(strings[1]));
                    break;
                case "3":
                    System.out.println(heap.peek());
                    break;
            }
        }
    }
}

@SuppressWarnings({"WeakerAccess", "Duplicates"})
class Heap {

    private static final int ROOT_INDEX = 0;

    private int[] values;
    private int size;

    public Heap(int size) {
        this.values = new int[size];
    }

    public void add(int element) {
        int lastLeafIndex = ++size - 1;
        values[lastLeafIndex] = element;
        siftUp(lastLeafIndex);
    }

    public int peek() {
        return values[ROOT_INDEX];
    }

    public void remove(int value) {
        for (int index = 0; index < size; index++) {
            if (value == values[index]) {
                int lastLeafIndex = --size;
                values[index] = values[lastLeafIndex];
                values[lastLeafIndex] = 0;
                siftDown(index);
            }
        }
    }

    private void siftUp(int nodeIndex) {
        while (nodeIndex != ROOT_INDEX && values[nodeIndex / 2] > values[nodeIndex]) {
            int parentIndex = nodeIndex / 2;
            swapNodes(nodeIndex, parentIndex);
            nodeIndex = parentIndex;
        }
    }

    private void siftDown(int nodeIndex) {
        while (nodeIndex * 2 < size) {
            int leftChildIndex = nodeIndex * 2;
            int rightChildIndex = nodeIndex * 2 + 1;

            int min = nodeIndex;
            if (leftChildIndex < size && values[min] > values[leftChildIndex]) {
                min = leftChildIndex;
            }
            if (rightChildIndex < size && values[min] > values[rightChildIndex]) {
                min = rightChildIndex;
            }

            if (min == nodeIndex) break;
            swapNodes(nodeIndex, min);
            nodeIndex = min;
        }
    }

    private void swapNodes(int a, int b) {
        int temp = values[a];
        values[a] = values[b];
        values[b] = temp;
    }
}
