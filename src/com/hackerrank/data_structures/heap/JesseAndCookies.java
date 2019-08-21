package com.hackerrank.data_structures.heap;

import java.util.Scanner;

public class JesseAndCookies {

    static int cookies(int k, int[] cookies) {
        if (cookies.length == 0) return -1;

        PriorityQueue cookieQueue = new PriorityQueue(cookies.length);
        for (int cookie : cookies) {
            cookieQueue.add(cookie);
        }

        int operationCount = 0;
        while (cookieQueue.size() > 1 && cookieQueue.peek() < k) {
            int min = cookieQueue.poll();
            int min2 = cookieQueue.poll();
            int combinedCookie = min + min2 * 2;
            cookieQueue.add(combinedCookie);
            operationCount++;
        }
        return cookieQueue.peek() >= k ? operationCount : -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());
        int k = Integer.parseInt(nk[1].trim());

        int[] cookies = new int[n];
        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            cookies[AItr] = AItem;
        }

        int result = cookies(k, cookies);

        System.out.println(result);
    }
}

@SuppressWarnings({"WeakerAccess", "Duplicates"})
class PriorityQueue {

    private static final int ROOT_INDEX = 0;

    private int[] values;
    private int size;

    public PriorityQueue(int size) {
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

    public int poll() {
        int minimal = values[ROOT_INDEX];
        int lastLeafIndex = size - 1;
        values[ROOT_INDEX] = values[lastLeafIndex];
        values[lastLeafIndex] = 0;
        size--;
        siftDown(ROOT_INDEX);
        return minimal;
    }

    public int size() {
        return size;
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
