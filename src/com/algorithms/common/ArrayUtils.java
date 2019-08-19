package com.algorithms.common;

import java.util.Arrays;
import java.util.function.Consumer;

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

    public static void printWithIndex(int[] array) {
        System.out.println(toStringWithIndex(array));
    }

    public static int getRandomEntry(int[] array) {
        if (array.length == 0) throw new IllegalArgumentException();
        int randomIndex = createRandomIntBetween(0, array.length - 1);
        return array[randomIndex];
    }

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
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
}
