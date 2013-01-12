package com.jayway.lab.wordcounter;

import com.jayway.lab.wordcounter.support.InitializeWordCounter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Collection;

public class ImmutableCollectionSpec extends InitializeWordCounter {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test(expected = UnsupportedOperationException.class) public void
    get_unique_words_in_order_returns_an_immutable_collection() {
        /*
         * The purpose of this exercise is to the make collection returned by
         * "getUniqueWordsInOrder" immutable in a _fluent_ manner.
         * E.g. you're not allowed to do:
         * ..
         * return Collections.unmodifiableCollection(words);
         */

        // When
        final Collection<String> words = wordCounter.getUniqueWordsInOrder(tale);

        // Then
        words.add("word");
    }
}
