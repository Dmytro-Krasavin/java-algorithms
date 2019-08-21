package com.hackerrank.data_structures.heap;

import java.util.*;
import java.util.function.BiConsumer;

public class QueryHeap {

    private static final Map<String, BiConsumer<String[], Heap>> queryToHeapAction = Collections.unmodifiableMap(
            new HashMap<String, BiConsumer<String[], Heap>>(3) {{
                put("1", (strings, heap) -> {
                    int value = Integer.parseInt(strings[1]);
                    heap.insert(value);
                });
                put("2", (strings, heap) -> {
                    int value = Integer.parseInt(strings[1]);
                    heap.delete(value);
                });
                put("3", (strings, heap) -> {
                    int min = heap.peekMin();
                    System.out.println(min);
                });
            }});

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());
        Heap heap = new Heap(queriesCount);

        String[] queries = new String[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            queries[i] = scanner.nextLine().trim();
        }

        for (String query : queries) {
            String[] strings = query.split(" ");
            String queryId = strings[0];
            BiConsumer<String[], Heap> heapAction = queryToHeapAction.get(queryId);
            heapAction.accept(strings, heap);
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

    public void insert(int element) {
        int lastLeafIndex = ++size - 1;
        values[lastLeafIndex] = element;
        siftUp(lastLeafIndex);
    }

    public int peekMin() {
        return values[ROOT_INDEX];
    }

    public void delete(int value) {
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
