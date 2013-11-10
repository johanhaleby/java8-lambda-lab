package com.jayway.lab.summarizer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ListSummarizer {

    public List<Integer> sumElementByElementInListOfLists(List<List<Integer>> numbers) {
        final long numberOfDifferentLengths = numbers.stream().mapToInt(list -> list.size()).distinct().count();
        if (numberOfDifferentLengths == 0) {
            throw new IllegalArgumentException("You need to supply some numbers.");
        } else if (numberOfDifferentLengths > 1) {
            throw new IllegalArgumentException("You need to supply lists of equal size.");
        }

        return numbers.stream().collect(() -> {
            List<List<Integer>> supplier = new ArrayList<>();
            for (int i = 0; i < numbers.get(0).size(); i++) {
                supplier.add(new ArrayList<>());
            }
            return supplier;
        }, (List<List<Integer>> acc, List<Integer> integers) -> {
            for (int i = 0; i < integers.size(); i++) {
                int number = integers.get(i);
                acc.get(i).add(number);
            }
        }, List<List<Integer>>::addAll).stream().map(integers -> integers.stream().reduce(0, Integer::sum)).collect(Collectors.toList());
    }
}
