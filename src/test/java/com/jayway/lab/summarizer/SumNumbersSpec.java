package com.jayway.lab.summarizer;

import com.jayway.lab.summarizer.support.InitializeSummarizer;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class SumNumbersSpec extends InitializeSummarizer {

    @Test public void
    sums_the_given_numbers() {
        // When
        final int sum = summarizer.sumNumbers("1", "2", "3", "4", "5");

        // Then
        assertThat(sum).isEqualTo(15);
    }

    @Test public void
    returns_zero_when_no_numbers_are_provided() {
        // When
        final int sum = summarizer.sumNumbers();

        // Then
        assertThat(sum).isEqualTo(0);

    }
}
