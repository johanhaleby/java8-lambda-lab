package com.jayway.lab.summarizer;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

public class ListSummarizer {

    public List<Integer> sumElementByElementInListOfLists(List<List<Integer>> numbers) {
        final long numberOfDifferentLengths = numbers.stream().mapToInt(list -> list.size()).distinct().count();
        if (numberOfDifferentLengths == 0) {
            throw new IllegalArgumentException("You need to supply some numbers.");
        } else if (numberOfDifferentLengths > 1) {
            throw new IllegalArgumentException("You need to supply lists of equal size.");
        }

        final int numberOfElementsInEachList = numbers.get(0).size();
        return numbers.stream().reduce(new ArrayList<Integer>(numberOfElementsInEachList) {{
            range(0, numberOfElementsInEachList).forEach((i) -> add(0));
        }}, (acc, listNumbers) -> { // Where's zip?
            range(0, listNumbers.size()).forEach((i) -> acc.set(i, acc.get(i) + listNumbers.get(i)));
            return acc;
        });
    }
}
