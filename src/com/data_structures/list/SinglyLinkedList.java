package com.data_structures.list;

import java.util.Iterator;

@SuppressWarnings({"WeakerAccess", "Duplicates"})
public class SinglyLinkedList<T> implements LinkedList<T> {

    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    private final int[] next;
    private final T[] values;

    private int free = 1;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public SinglyLinkedList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public SinglyLinkedList(int size) {
        this.next = new int[size];
        this.values = (T[]) new Object[size];
    }

    @Override
    public void addFirst(T item) {
        addAfter(head, item);
    }

    @Override
    public void addLast(T item) {
        addAfter(tail, item);
    }

    @Override
    public void addAfter(int index, T item) {
        next[free] = next[index];
        next[index] = free;
        values[free] = item;
        if (index == tail) tail = free;
        free++;
    }

    @Override
    public T removeFirst() {
        return removeAfter(head);
    }

    @Override
    public T removeLast() {
        return removeAfter(--tail);
    }

    @Override
    public T removeAfter(int index) {
        int itemIndex = next[index];
        T item = values[itemIndex];
        next[index] = next[itemIndex];
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index = next[head];

            @Override
            public boolean hasNext() {
                return index != 0;
            }

            @Override
            public T next() {
                T item = values[index];
                index = next[index];
                return item;
            }
        };
    }


    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.forEach(System.out::println);
        Integer first = list.removeFirst();
        Integer last = list.removeLast();
        Integer last2 = list.removeLast();
        System.out.println();
    }
}
