package com.jayway.lab.wordcounter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.Collections.unmodifiableCollection;
import static java.util.Collections.unmodifiableList;

public class ImmutableCollector {

    public static <T, C extends Collection<T>> Collector<T, ?, C> toImmutableCollection(Supplier<C> collectionFactory) {
        return Collector.of(collectionFactory, Collection<T>::add, (r1, r2) -> {
            r1.addAll(r2);
            return r1;
        }, collection -> (C) unmodifiableCollection(collection));
    }

    public static <T, C extends Collection<T>> Collector<T, ?, C> toImmutableCollection() {
        return toImmutableCollection(() -> (C) new ArrayList<>());
    }

    public static <T, C extends List<T>> Collector<T, ?, C> toImmutableList(Supplier<C> collectionFactory) {
        return Collector.of(collectionFactory, List::add, (left, right) -> {
            left.addAll(right);
            return left;
        }, list -> (C) unmodifiableList(list));
    }

    public static <T, C extends List<T>> Collector<T, ?, C> toImmutableList() {
        return toImmutableList(() -> (C) new ArrayList<>());
    }
}
