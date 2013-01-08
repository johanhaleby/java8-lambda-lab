package com.jayway.lab;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

public class ImmutableCollectionBuilder<T> implements Stream.Destination<T> {

    private final Collection<T> a;

    private ImmutableCollectionBuilder(Collection<T> a) {
        this.a = a;
    }

    @Override
    public void addAll(Stream<? extends T> stream) {
        a.addAll(stream);
    }

    public Collection<T> immutable() {
        return Collections.unmodifiableCollection(a);
    }

    public static <T> ImmutableCollectionBuilder<T> a(Collection<T> collection) {
        return new ImmutableCollectionBuilder<T>(collection);
    }
}
