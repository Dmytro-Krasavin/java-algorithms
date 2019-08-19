package com.data_structures.heap;

import java.util.function.BiPredicate;

@SuppressWarnings("unchecked")
public enum HeapProperty {

    MINIMUM((parent, child) -> parent.compareTo(child) <= 0),

    MAXIMUM((parent, child) -> parent.compareTo(child) >= 0);

    private final BiPredicate<Comparable, Comparable> heapCondition;

    HeapProperty(BiPredicate<Comparable, Comparable> heapCondition) {
        this.heapCondition = heapCondition;
    }

    public <T extends Comparable> boolean isSatisfied(T parent, T child) {
        return heapCondition.test(parent, child);
    }
}
