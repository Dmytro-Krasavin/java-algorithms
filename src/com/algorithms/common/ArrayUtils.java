package com.algorithms.common;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public enum ArrayUtils {
    ;

    public static int[] generateRandomArray(int size, int maxValue) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * maxValue);
        }
        return array;
    }

    public static void withLogging(int[] array, Consumer<int[]> sortConsumer) {
        print(array);

        long start = System.nanoTime();
        sortConsumer.accept(array);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Elapsed time: " + elapsedTime);

        print(array);
    }

    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void printWithMiddle(int left, int right, int middle) {
        System.out.println(toStringWithMiddle(IntStream.range(left, right).toArray(), middle));
    }

    public static void printWithIndex(int[] array) {
        System.out.println(toStringWithIndex(array));
    }

    private static String toStringWithIndex(int[] array) {
        int iMax = array.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append("[");
            b.append(i);
            b.append("]=");
            b.append(array[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    private static String toStringWithMiddle(int[] array, int middleIndex) {
        int iMax = array.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            if (array[i] == middleIndex) {
                b.append("<<");
                b.append("[");
                b.append(i);
                b.append("]=");
                b.append(array[i]);
                b.append(">>");
            } else {
                b.append("[");
                b.append(i);
                b.append("]=");
                b.append(array[i]);
            }

            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}
