package com.data_structures.queue;

@SuppressWarnings("WeakerAccess")
public class Deque<T> {

    private static final int DEFAULT_INITIAL_CAPACITY = 5;

    private final T[] values;

    private int headIndex = 0;
    private int tailIndex = 0;

    public Deque() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public Deque(int size) {
        this.values = (T[]) new Object[size];
    }

    public void pushLast(T item) {
        tailIndex++;
        if (tailIndex >= values.length) {
            tailIndex = 0;
        }
        values[tailIndex] = item;
    }

    public void pushFirst(T item) {
        headIndex--;
        if (headIndex < 0) {
            headIndex = values.length - 1;
        }
        values[headIndex] = item;
    }

    public T popLast() {
        T item = values[tailIndex];
        values[tailIndex] = null;
        tailIndex--;
        if (tailIndex < 0) {
            tailIndex = values.length - 1;
        }
        return item;
    }

    public T popFirst() {
        T item = values[headIndex];
        values[headIndex] = null;
        headIndex++;
        if (headIndex >= values.length) {
            headIndex = 0;
        }
        return item;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.pushFirst(0);
        deque.pushFirst(1);
        deque.pushFirst(2);
        deque.pushFirst(3);
        deque.pushLast(4);
        Integer popFirst = deque.popFirst();
        Integer popFirst1 = deque.popFirst();
        Integer popLast = deque.popLast();
    }
}
