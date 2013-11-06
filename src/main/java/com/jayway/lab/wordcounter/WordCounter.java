package com.jayway.lab.wordcounter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

public class WordCounter {

    public Collection<String> getUniqueWordsInOrder(String string) {
        final List<String> words = getWordsAsList(string);

        return words.stream().filter(word -> !word.isEmpty()).map(String::toLowerCase).sorted(String::compareTo).
                distinct().collect(toCollection(ArrayList::new));
    }

    public Map<String, Long> getNumberOfInstancesForEachWord(String string) {
        final List<String> words = getWordsAsList(string);

        return words.stream().filter(word -> !word.isEmpty()).map(String::toLowerCase).sorted(String::compareTo).
                collect(groupingBy(Function.<String>identity(), TreeMap::new, Collectors.counting()));
    }

    private List<String> getWordsAsList(String string) {
        final String[] split = string.split("\\W+");
        return asList(split);
    }
}
