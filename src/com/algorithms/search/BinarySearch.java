package com.algorithms.search;

import java.util.Arrays;

import static com.algorithms.common.ArrayUtils.*;

@SuppressWarnings({"WeakerAccess"})
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = generateRandomArray(20, 20);

        Arrays.sort(array);
        printWithIndex(array);
        System.out.println();

        Integer index = search(array, 8);

        System.out.println();
        System.out.println(index != null ? "[" + index + "]=" + array[index] : "Not found");
    }

    public static Integer search(int[] array, int item) {
        int middle;
        int left = 0;
        int right = array.length;

        while (right - left > 1) {
            middle = (left + right) / 2;
            printWithMiddle(array, left, right, middle);
            if (array[middle] >= item) {
                right = middle;
            } else {
                left = middle;
            }
        }
        if ((right < array.length) && (array[right] == item)) {
            return right;
        }
        return null;
    }

    public static Integer searchRecursively(int[] array, int item) {
        if (array.length < 2) return null;
        int middleIndex = array.length / 2;
        int middle = array[middleIndex];
        if (item > middle) {
            return searchRecursively(Arrays.copyOfRange(array, middleIndex, array.length), item);
        } else if (item < middle) {
            return searchRecursively(Arrays.copyOfRange(array, 0, middleIndex), item);
        } else {
            return item;
        }
    }
}
