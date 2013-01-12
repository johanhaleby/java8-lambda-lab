package com.jayway.lab.wordcounter;

import com.jayway.lab.wordcounter.support.InitializeWordCounter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.MapAssert.entry;

public class GetNumberOfInstancesForEachWordSpec extends InitializeWordCounter {

    @Test public void
    returns_a_map_with_number_of_instances_of_each_word() {
        // When
        final Map<String,Integer> numberOfInstancesForEachWord = wordCounter.getNumberOfInstancesForEachWord(tale);

        // Then
        assertThat(numberOfInstancesForEachWord).hasSize(57).includes(entry("a", 3), entry("about", 4), entry("and", 10), entry("appear", 1),
                entry("as", 1), entry("at", 1), entry("but", 1), entry("children", 3), entry("cry", 1), entry("day", 4), entry("did", 2),
                entry("does", 2), entry("eager", 1), entry("everywhere", 2), entry("fleece", 1), entry("followed", 2), entry("go", 1),
                entry("had", 2), entry("her", 2), entry("it", 9), entry("know", 4), entry("lamb", 12), entry("laugh", 4), entry("lingered", 1),
                entry("little", 4), entry("love", 4), entry("loves", 2), entry("made", 2), entry("mary", 13), entry("near", 1), entry("one", 4),
                entry("out", 4), entry("patiently", 4), entry("play", 4), entry("reply", 1), entry("rules", 1), entry("school", 5), entry("see", 1),
                entry("snow", 1), entry("so", 6), entry("still", 1), entry("sure", 1), entry("teacher", 3), entry("that", 2), entry("the", 14),
                entry("till", 1), entry("to", 4), entry("turned", 4), entry("waited", 2), entry("was", 3), entry("went", 4), entry("which", 1),
                entry("white", 1), entry("whose", 1), entry("why", 4), entry("you", 4)

        );
    }

    @Test public void
    returns_a_map_ordered_by_name() {
        // When
        final Map<String,Integer> numberOfInstancesForEachWord = wordCounter.getNumberOfInstancesForEachWord(tale);

        // Then
        assertThat(new ArrayList<>(numberOfInstancesForEachWord.keySet())).containsExactly("a", "about", "against", "and", "appear", "as",
                "at", "but", "children", "cry", "day", "did", "does", "eager", "everywhere", "fleece", "followed", "go", "had", "her", "it",
                "know", "lamb", "laugh", "lingered", "little", "love", "loves", "made", "mary", "near", "one", "out", "patiently", "play",
                "reply", "rules", "school", "see", "snow", "so", "still", "sure", "teacher", "that", "the", "till", "to", "turned", "waited",
                "was", "went", "which", "white", "whose", "why", "you");
    }
}
