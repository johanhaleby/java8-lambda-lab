package com.jayway.lab;

import java.util.*;
import java.util.function.BiFunction;

import static com.jayway.lab.ImmutableCollectionBuilder.a;
import static java.util.Arrays.asList;

public class WordCounter {
    private static final BiFunction<TreeMap<String,Integer>,String,TreeMap<String,Integer>> GROUP_BY = (map, word) -> {
        int value;
        if (map.containsKey(word)) {
            value = map.get(word) + 1;
        } else {
            value = 1;
        }
        map.put(word, value);
        return map;
    };


    public Collection<String> getUniqueWordsInOrder(String string) {
        final List<String> words = getWordsAsList(string);

        return words.stream().filter(word -> !word.isEmpty()).map(String::toLowerCase).sorted(String::compareTo).
                uniqueElements().into(a(new ArrayList<String>())).immutable();
    }

    public Map<String, Integer> getNumberOfInstancesForEachWord(String string) {
        final List<String> words = getWordsAsList(string);
        return words.stream().filter(word -> !word.isEmpty()).map(String::toLowerCase).sorted(String::compareTo).
                reduce(new TreeMap<String, Integer>(), GROUP_BY, (map, word) -> null);
    }

    private List<String> getWordsAsList(String string) {
        final String[] split = string.split("\\W+");
        return asList(split);
    }
}
