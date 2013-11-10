package com.jayway.lab.summarizer;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.then;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.when;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

public class ListSummarizerSpec {

    private ListSummarizer summarizer;

    @Before
    public void
    given_list_summarizer_is_initialized() {
        summarizer = new ListSummarizer();
    }

    @Test public void
    sums_element_by_element() {
        // When
        List<Integer> sum = summarizer.sumElementByElementInListOfLists(asList(asList(1, 2, 3, 4, 5), asList(2, 3, 4, 5, 6), asList(10, 20, 30, 40, 50)));

        // Then
        assertThat(sum).containsExactly(13, 25, 37, 49, 61);
    }

    @Test public void
    throws_iae_when_no_numbers_are_supplied() {
        // When
        when(summarizer).sumElementByElementInListOfLists(emptyList());

        // When
        then(caughtException()).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("You need to supply some numbers.");

    }

    @Test public void
    throws_iae_when_lists_are_of_different_sizes() {
        // When
        when(summarizer).sumElementByElementInListOfLists(asList(asList(1, 2, 3, 4, 5), asList(2, 3, 4, 5, 6), asList(10, 20, 11, 30, 40, 50)));

        // Then
        then(caughtException()).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("You need to supply lists of equal size.");
    }
}
