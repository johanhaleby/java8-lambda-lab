package com.jayway.lab.wordcounter;

import com.jayway.lab.wordcounter.support.InitializeWordCounter;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collection;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.then;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.when;

public class ImmutableCollectionSpec extends InitializeWordCounter {

    @Test public void
    get_unique_words_in_order_returns_an_immutable_collection() {
        /*
         * The purpose of this exercise is to the make collection returned by
         * "getUniqueWordsInOrder" immutable in a _fluent_ manner.
         * E.g. you're not allowed to do:
         * ..
         * return Collections.unmodifiableCollection(words);
         */

        // Given
        final Collection<String> words = wordCounter.getUniqueWordsInOrder(tale);

        // When
        when(words).add("word");

        // Then
        then(caughtException()).describedAs("Collection was not immutable").isExactlyInstanceOf(UnsupportedOperationException.class);
    }
}
