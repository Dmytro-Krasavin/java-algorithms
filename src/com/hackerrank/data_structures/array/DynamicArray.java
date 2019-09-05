package com.hackerrank.data_structures.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    static List<Integer> dynamicArray(int sequenceCount, List<List<Integer>> queries) {
        List<Integer> results = new ArrayList<>();
        int lastAnswer = 0;

        List<List<Integer>> sequences = new ArrayList<>();
        for (int i = 0; i < sequenceCount; i++) {
            sequences.add(new ArrayList<>());
        }

        for (List<Integer> query : queries) {
            int queryType = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            int sequenceIndex = (x ^ lastAnswer) % sequenceCount;
            List<Integer> sequence = sequences.get(sequenceIndex);

            switch (queryType) {
                case 1: {
                    sequence.add(y);
                    break;
                }
                case 2: {
                    int lastAnswerIndex = y % sequence.size();
                    lastAnswer = sequence.get(lastAnswerIndex);
                    results.add(lastAnswer);
                    break;
                }
            }
        }
        return results;
    }
}

class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int sequenceCount = Integer.parseInt(firstMultipleInput[0]);
            int queryCount = Integer.parseInt(firstMultipleInput[1]);

            List<List<Integer>> queries = new ArrayList<>(queryCount);
            for (int i = 0; i < queryCount; i++) {
                String[] values = bufferedReader.readLine()
                        .replaceAll("\\s+$", "")
                        .split(" ");
                List<Integer> query = Stream.of(values)
                        .map(Integer::parseInt)
                        .collect(toList());
                queries.add(query);
            }

            List<Integer> result = Result.dynamicArray(sequenceCount, queries);
            String output = result.stream()
                    .map(Object::toString)
                    .collect(joining("\n"));
            System.out.println(output);
        }
    }
}
