package com.jayway.lab.summarizer;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumNumbersSpec {

    private Summarizer summarizer;

    @Before
    public void
    given_summarizer_is_initialized() {
        summarizer = new Summarizer();
    }

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
