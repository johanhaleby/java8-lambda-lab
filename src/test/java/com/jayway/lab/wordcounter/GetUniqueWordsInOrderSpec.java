package com.jayway.lab.wordcounter;

import com.jayway.lab.WordCounter;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;

public class GetUniqueWordsInOrderSpec {

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

    @Test public void
    tale_has_57_words() {
        // When
        final Collection<String> words = wordCounter.getUniqueWordsInOrder(tale);

        // Then
        assertThat(words).hasSize(57);
    }

    @Test public void
    tale_contains_only_the_expected_words() {
        // When
        final Collection<String> words = wordCounter.getUniqueWordsInOrder(tale);

        // Then
        assertThat(words).containsOnly("a", "about", "against", "and", "appear", "as", "at", "but", "children", "cry", "day", "did", "does",
                "eager", "everywhere", "fleece", "followed", "go", "had", "her", "it", "know", "lamb", "laugh", "lingered", "little", "love",
                "loves", "made", "mary", "near", "one", "out", "patiently", "play", "reply", "rules", "school", "see", "snow", "so", "still",
                "sure", "teacher", "that", "the", "till", "to", "turned", "waited", "was", "went", "which", "white", "whose", "why", "you");
    }

    @Test public void
    tale_contains_only_the_expected_words_in_order() {
        // When
        final Collection<String> words = wordCounter.getUniqueWordsInOrder(tale);

        // Then
        assertThat(new ArrayList<>(words)).containsExactly("a", "about", "against", "and", "appear", "as", "at", "but", "children", "cry",
                "day", "did", "does", "eager", "everywhere", "fleece", "followed", "go", "had", "her", "it", "know", "lamb", "laugh",
                "lingered", "little", "love", "loves", "made", "mary", "near", "one", "out", "patiently", "play", "reply", "rules", "school",
                "see", "snow", "so", "still", "sure", "teacher", "that", "the", "till", "to", "turned", "waited", "was", "went", "which",
                "white", "whose", "why", "you");
    }
}
