package com.jayway.lab.numberclassification;

import org.junit.Before;
import org.junit.Test;

import static com.jayway.lab.numberclassification.Classification.*;
import static org.fest.assertions.Assertions.assertThat;

public class NumberClassifierSpec {

    private NumberClassifier numberClassifier;

    @Before public void
    given_number_classifier_is_instantiated() {
        numberClassifier = new NumberClassifier();
    }

    @Test public void
    number_is_perfect_when_sum_of_the_factors_of_the_number_equals_the_number_times_two() {
        // Given
        int perfectNumber = 6;

        // When
        final Classification classification = numberClassifier.classify(perfectNumber);

        // Then
        assertThat(classification).isEqualTo(PERFECT);
    }

    @Test public void
    number_is_abundant_when_sum_of_the_factors_of_the_number_is_greater_than_the_number_times_two() {
        // Given
        int abundantNumber = 102;

        // When
        final Classification classification = numberClassifier.classify(abundantNumber);

        // Then
        assertThat(classification).isEqualTo(ABUNDANT);
    }

    @Test public void
    number_is_deficient_when_sum_of_the_factors_of_the_number_is_less_than_the_number_times_two() {
        // Given
        int deficientNumber = 27;

        // When
        final Classification classification = numberClassifier.classify(deficientNumber);

        // Then
        assertThat(classification).isEqualTo(DEFICIENT);
    }

    @Test(expected = IllegalArgumentException.class) public void
    throws_illegal_argument_exception_when_number_is_less_zero() {
        // Given
        int number = -21;

        // When
        numberClassifier.classify(number);
    }

    @Test(expected = IllegalArgumentException.class) public void
    throws_illegal_argument_exception_when_number_is_zero() {
        // Given
        int number = 0;

        // When
        numberClassifier.classify(number);
    }
}
