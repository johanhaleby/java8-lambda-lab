package com.jayway.lab.wordcounter.support;

import com.jayway.lab.wordcounter.WordCounter;
import org.apache.commons.io.IOUtils;
import org.junit.Before;

import java.io.IOException;

public class InitializeWordCounter {
    protected String tale;
    protected WordCounter wordCounter;

    @Before public void
    given_tale_is_loaded_to_memory() throws IOException {
        tale = IOUtils.toString(getClass().getResourceAsStream("/mary.txt"));
    }

    @Before public void
    given_word_counter_is_instantiated() {
        wordCounter = new WordCounter();
    }
}
