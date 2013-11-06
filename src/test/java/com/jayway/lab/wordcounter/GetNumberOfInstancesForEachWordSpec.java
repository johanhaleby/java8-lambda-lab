package com.jayway.lab.wordcounter;

import com.jayway.lab.wordcounter.support.InitializeWordCounter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class GetNumberOfInstancesForEachWordSpec extends InitializeWordCounter {

    @Test public void
    returns_a_map_with_number_of_instances_of_each_word() {
        // When
        final Map<String, Long> numberOfInstancesForEachWord = wordCounter.getNumberOfInstancesForEachWord(tale);

        // Then
        assertThat(numberOfInstancesForEachWord).hasSize(57).contains(entry("a", 3L), entry("about", 4L), entry("and", 10L), entry("appear", 1L),
                entry("as", 1L), entry("at", 1L), entry("but", 1L), entry("children", 3L), entry("cry", 1L), entry("day", 4L), entry("did", 2L),
                entry("does", 2L), entry("eager", 1L), entry("everywhere", 2L), entry("fleece", 1L), entry("followed", 2L), entry("go", 1L),
                entry("had", 2L), entry("her", 2L), entry("it", 9L), entry("know", 4L), entry("lamb", 12L), entry("laugh", 4L), entry("lingered", 1L),
                entry("little", 4L), entry("love", 4L), entry("loves", 2L), entry("made", 2L), entry("mary", 13L), entry("near", 1L), entry("one", 4L),
                entry("out", 4L), entry("patiently", 4L), entry("play", 4L), entry("reply", 1L), entry("rules", 1L), entry("school", 5L), entry("see", 1L),
                entry("snow", 1L), entry("so", 6L), entry("still", 1L), entry("sure", 1L), entry("teacher", 3L), entry("that", 2L), entry("the", 14L),
                entry("till", 1L), entry("to", 4L), entry("turned", 4L), entry("waited", 2L), entry("was", 3L), entry("went", 4L), entry("which", 1L),
                entry("white", 1L), entry("whose", 1L), entry("why", 4L), entry("you", 4L)

        );
    }

    @Test public void
    returns_a_map_ordered_by_name() {
        // When
        final Map<String, Long> numberOfInstancesForEachWord = wordCounter.getNumberOfInstancesForEachWord(tale);

        // Then
        assertThat(new ArrayList<>(numberOfInstancesForEachWord.keySet())).containsExactly("a", "about", "against", "and", "appear", "as",
                "at", "but", "children", "cry", "day", "did", "does", "eager", "everywhere", "fleece", "followed", "go", "had", "her", "it",
                "know", "lamb", "laugh", "lingered", "little", "love", "loves", "made", "mary", "near", "one", "out", "patiently", "play",
                "reply", "rules", "school", "see", "snow", "so", "still", "sure", "teacher", "that", "the", "till", "to", "turned", "waited",
                "was", "went", "which", "white", "whose", "why", "you");
    }
}
