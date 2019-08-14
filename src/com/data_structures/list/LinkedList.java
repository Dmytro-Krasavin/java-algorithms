package com.data_structures.list;

public interface LinkedList<T> extends Iterable<T> {

    void addFirst(T item);

    void addLast(T item);

    void addAfter(int index, T item);

    T removeFirst();

    T removeLast();

    T removeAfter(int index);

    boolean isEmpty();

    int size();

}
