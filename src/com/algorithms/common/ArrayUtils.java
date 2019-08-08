package com.algorithms.common;

import java.util.Arrays;
import java.util.function.Consumer;

public class ArrayUtils {

    public static int[] generateRandomArray(int size, int maxValue) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * maxValue);
        }
        return array;
    }

    public static void withProfiling(int[] array, Consumer<int[]> sortConsumer) {
        print(array);

        long start = System.nanoTime();
        sortConsumer.accept(array);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Elapsed time: " + elapsedTime);

        print(array);
    }

    private static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
