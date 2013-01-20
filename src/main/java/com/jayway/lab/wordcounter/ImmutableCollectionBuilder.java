package com.jayway.lab.wordcounter;

import java.util.Collection;
import java.util.Collections;
import java.util.function.BiBlock;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collectors.asBinaryOperator;

public class ImmutableCollectionBuilder<T> implements Collector<T, ImmutableCollectionBuilder.ToImmutable<T>> {

    private final Supplier<? extends Collection<T>> supplier;
    private final BiBlock<ToImmutable<T>, T> accumulator;
    private final BinaryOperator<ToImmutable<T>> reducer;

    private ImmutableCollectionBuilder(Supplier<? extends Collection<T>> supplier, BiBlock<ToImmutable<T>, T> accumulator, BinaryOperator<ToImmutable<T>> reducer) {
        this.supplier = supplier;
        this.accumulator = accumulator;
        this.reducer = reducer;
    }

    @Override
    public ToImmutable<T> makeResult() {
        return new ToImmutable<T>(supplier.get());
    }

    @Override
    public void accumulate(ToImmutable<T> result, T value) {
        accumulator.accept(result, value);
    }

    @Override
    public ToImmutable<T> combine(ToImmutable<T> result, ToImmutable<T> other) {
        return reducer.apply(result, other);
    }

    public static <T> ImmutableCollectionBuilder<T> a(Supplier<? extends Collection<T>> supplier) {
        return new ImmutableCollectionBuilder<T>(supplier, ToImmutable::add, asBinaryOperator(ToImmutable::addAll));
    }

    public static class ToImmutable<T> {
        private final Collection<T> list;

        public ToImmutable(Collection<T> list) {
            this.list = list;
        }

        public Collection<T> immutable() {
            return Collections.unmodifiableCollection(list);
        }

        public boolean add(T e) {
            return list.add(e);
        }

        public boolean addAll(ToImmutable<T> e) {
            return list.addAll(e.list);
        }
    }
}
