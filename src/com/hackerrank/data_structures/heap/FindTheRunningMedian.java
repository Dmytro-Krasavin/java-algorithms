package com.hackerrank.data_structures.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

@SuppressWarnings("Duplicates")
public class FindTheRunningMedian {

    static double[] runningMedian(int[] array) {
        double[] medians = new double[array.length];

        double median = array[0];
        medians[0] = median;

        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> greater = new PriorityQueue<>();
        smaller.add((int) median);

        for (int i = 1; i < array.length; i++) {
            medians[i] = median = calculateMedian(array[i], median, smaller, greater);
        }
        return medians;
    }

    private static double calculateMedian(int element, double median, PriorityQueue<Integer> smaller, PriorityQueue<Integer> greater) {
        if (smaller.size() > greater.size()) {
            if (element < median) {
                greater.add(smaller.remove());
                smaller.add(element);
            } else {
                greater.add(element);
            }
            median = calculateAverage(smaller.element(), greater.element());
        } else if (smaller.size() == greater.size()) {
            if (element < median) {
                smaller.add(element);
                median = (double) smaller.element();
            } else {
                greater.add(element);
                median = (double) greater.element();
            }
        } else {
            if (element > median) {
                smaller.add(greater.remove());
                greater.add(element);
            } else {
                smaller.add(element);
            }
            median = calculateAverage(smaller.element(), greater.element());
        }
        return median;
    }

    private static double calculateAverage(int a, int b) {
        return (double) (a + b) / 2;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int aCount = Integer.parseInt(bufferedReader.readLine().trim());
            int[] a = new int[aCount];

            for (int aItr = 0; aItr < aCount; aItr++) {
                int aItem = Integer.parseInt(bufferedReader.readLine().trim());
                a[aItr] = aItem;
            }

            double[] result = runningMedian(a);

            StringBuilder sb = new StringBuilder();
            for (int resultItr = 0; resultItr < result.length; resultItr++) {
                sb.append(String.valueOf(result[resultItr]));

                if (resultItr != result.length - 1) {
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());
        }
    }
}


