package com.jayway.lab.wordcounter;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ImmutableCollector {

    public static <T, A extends Collection<T>> Collector<T, A, Collection<T>> toImmutableCollection(Supplier<A> collectionFactory) {
        return null;
    }

    public static <T> Collector<T, Collection<T>, Collection<T>> toImmutableCollection() {
        return null;
    }

    public static <T, A extends List<T>> Collector<T, A, List<T>> toImmutableList(Supplier<A> collectionFactory) {
        return null;
    }

    public static <T> Collector<T, List<T>, List<T>> toImmutableList() {
        return null;
    }
}
