package com.data_structures;

import java.util.EmptyStackException;

@SuppressWarnings("WeakerAccess")
public class Stack<T> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private final T[] values;

    private int topIndex = -1;

    public Stack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.values = (T[]) new Object[size];
    }

    public void push(T item) {
        values[++topIndex] = item;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return values[topIndex--];
    }

    public boolean isEmpty() {
        return topIndex == 0;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(7);
        int pop = stack.pop();
        int pop1 = stack.pop();
        stack.push(8);
        int pop2 = stack.pop();
    }
}
