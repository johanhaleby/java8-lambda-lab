package com.jayway.lab.wordcounter;

import com.jayway.lab.wordcounter.support.InitializeWordCounter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;

public class GetUniqueWordsInOrderSpec extends InitializeWordCounter {

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
