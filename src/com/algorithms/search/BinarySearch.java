package com.algorithms.search;

import java.util.Arrays;
import java.util.stream.IntStream;

import static com.algorithms.common.ArrayUtils.printWithIndex;

@SuppressWarnings({"WeakerAccess", "Duplicates"})
public class BinarySearch {

    public static void main(String[] args) {
//        int[] array = generateRandomArray(20, 5);
        int[] array = IntStream.range(3, 10).toArray();
        array[1] = 3;
        array[2] = 3;

        Arrays.sort(array);
        printWithIndex(array);
        System.out.println();

        int firstIndex = findFirstElementIndex(array, 3);
        int lastIndex = findLastElementIndex(array, 3);

        System.out.print("\nFirst: ");
        System.out.println(firstIndex > -1 ? "[" + firstIndex + "]=" + array[firstIndex] : "Not found");
        System.out.print("\nLast: ");
        System.out.println(lastIndex > -1 ? "[" + lastIndex + "]=" + array[lastIndex] : "Not found");
    }

    public static int findFirstElementIndex(int[] array, int element) {
        int start = -1;
        int end = array.length;

        while (end - start > 1) {
            int middle = (start + end) / 2;
            if (array[middle] >= element) {
                end = middle;
            } else {
                start = middle;
            }
        }
        if ((end < array.length) && (array[end] == element)) {
            return end;
        }
        return -1;
    }

    public static int findLastElementIndex(int[] array, int element) {
        int start = 0;
        int end = array.length - 1;

        while (end - start > 1) {
            int middle = start + ((end - start) + 1) / 2;
            if (array[middle] <= element) {
                start = middle;
            } else {
                end = middle - 1;
            }
        }
        return (array[end] == element) ? end : -1;
    }

    public static int findFirstElementIndexRecursively(int[] array, int start, int end, int element) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (array[end] >= element) {
                return findFirstElementIndexRecursively(array, start, mid, element);
            } else {
                return findFirstElementIndexRecursively(array, mid + 1, end, element);
            }
        }
        return (array[start] == element) ? start : -1;
    }

    public static int findLastElementIndexRecursively(int[] array, int start, int end, int element) {
        while (start < end) {
            int middle = start + ((end - start) + 1) / 2;

            if (array[middle] <= element) {
                return findLastElementIndexRecursively(array, middle, end, element);
            } else {
                return findLastElementIndexRecursively(array, start, middle - 1, element);
            }
        }
        return (array[start] == element) ? start : -1;
    }

}
