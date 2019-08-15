package com.data_structures.queue;

import java.util.EmptyStackException;

@SuppressWarnings("WeakerAccess")
public class Queue<T> {

    private static final int DEFAULT_INITIAL_CAPACITY = 5;

    private final T[] values;

    private int headIndex = 0;
    private int tailIndex = 0;

    public Queue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public Queue(int size) {
        this.values = (T[]) new Object[size];
    }

    public void push(T item) {
        values[tailIndex++] = item;
        if (tailIndex >= values.length) {
            tailIndex = 0;
        }
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T item = values[headIndex++];
        if (headIndex >= values.length) {
            headIndex = 0;
        }
        return item;
    }

    public boolean isEmpty() {
        return headIndex == tailIndex;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.push(5);
        queue.push(3);
        queue.push(7);
        int pop = queue.pop();
        int pop1 = queue.pop();
        queue.push(8);
        queue.push(4);
        int pop2 = queue.pop();
        queue.push(2);
        int pop3 = queue.pop();
        int pop4 = queue.pop();
        queue.push(1);
        int pop5 = queue.pop();
    }
}
