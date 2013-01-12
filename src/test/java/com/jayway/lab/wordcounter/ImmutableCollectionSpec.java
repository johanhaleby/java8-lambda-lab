package com.jayway.lab.wordcounter;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.Collection;

public class ImmutableCollectionSpec {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private String tale;
    private WordCounter wordCounter;

    @Before public void
    given_tale_is_loaded_to_memory() throws IOException {
        tale = IOUtils.toString(getClass().getResourceAsStream("/mary.txt"));
    }

    @Before public void
    given_word_counter_is_instantiated() {
        wordCounter = new WordCounter();
    }

    @Test(expected = UnsupportedOperationException.class) public void
    get_unique_words_in_order_returns_an_immutable_collection() {
        // When
        final Collection<String> words = wordCounter.getUniqueWordsInOrder(tale);

        // Then
        words.add("word");
    }
}
