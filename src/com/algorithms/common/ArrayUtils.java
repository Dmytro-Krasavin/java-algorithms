package com.algorithms.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LongSummaryStatistics;
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

    public static void withLogging(Integer[] array, Consumer<Integer[]> sortConsumer) {
        System.out.println(Arrays.toString(array));

        long start = System.nanoTime();
        sortConsumer.accept(array);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Elapsed time: " + elapsedTime);

        System.out.println(Arrays.toString(array));
    }

    public static void withStatistics(Consumer<int[]> sortConsumer, int testCount, int arraySize) {
        Collection<Long> timeUnits = new ArrayList<>();
        for (int i = 0; i < testCount; i++) {
            int[] array = generateRandomArray(arraySize, arraySize);
            long start = System.nanoTime();
            sortConsumer.accept(array);
            timeUnits.add(System.nanoTime() - start);
        }
        LongSummaryStatistics statistics = timeUnits.stream()
                .mapToLong(Long::longValue)
                .summaryStatistics();
        double average = statistics.getAverage();
        long max = statistics.getMax();
        long min = statistics.getMin();
        System.out.println("TestCount=" + testCount + "\nArray size=" + arraySize);
        System.out.println("\nAverage=" + average + "\nMax=" + max + "\nMin=" + min);
    }

    public static void withStatisticsBoxed(Consumer<Integer[]> sortConsumer, int testCount, int arraySize) {
        Collection<Long> timeUnits = new ArrayList<>();
        for (int i = 0; i < testCount; i++) {
            int[] array = generateRandomArray(arraySize, arraySize);
            Integer[] boxedArray = toBoxed(array);
            long start = System.nanoTime();
            sortConsumer.accept(boxedArray);
            timeUnits.add(System.nanoTime() - start);
        }
        LongSummaryStatistics statistics = timeUnits.stream()
                .mapToLong(Long::longValue)
                .summaryStatistics();
        double average = statistics.getAverage();
        long max = statistics.getMax();
        long min = statistics.getMin();
        System.out.println("TestCount=" + testCount + "\nArray size=" + arraySize);
        System.out.println("\nAverage=" + average + "\nMax=" + max + "\nMin=" + min);
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

    public static void swapNodes(int[] x, int a, int b) {
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public static void swapNodes(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public static Integer[] toBoxed(int[] array) {
        return Arrays.stream(array).boxed().toArray(Integer[]::new);
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
