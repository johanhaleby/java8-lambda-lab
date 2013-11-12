package com.jayway.lab.wordcounter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class ImmutableCollector {

    public static <T, A extends Collection<T>> Collector<T, A, Collection<T>> toImmutableCollection(Supplier<A> collectionFactory) {
        return Collector.of(collectionFactory, Collection::add, (left, right) -> {
            left.addAll(right);
            return left;
        }, Collections::unmodifiableCollection, IDENTITY_FINISH);
    }

    public static <T> Collector<T, Collection<T>, Collection<T>> toImmutableCollection() {
        return toImmutableCollection(ArrayList::new);
    }

    public static <T, A extends List<T>> Collector<T, A, List<T>> toImmutableList(Supplier<A> collectionFactory) {
        return Collector.of(collectionFactory, List::add, (left, right) -> {
            left.addAll(right);
            return left;
        }, Collections::unmodifiableList, IDENTITY_FINISH);
    }

    public static <T> Collector<T, List<T>, List<T>> toImmutableList() {
        return toImmutableList(ArrayList::new);
    }
}
