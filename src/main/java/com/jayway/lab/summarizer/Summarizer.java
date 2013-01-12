package com.jayway.lab.summarizer;

import static java.util.Arrays.asList;

public class Summarizer {

    public int sumNumbers(String... numbers) {
        return asList(numbers).stream().map(Integer::parseInt).reduce(0, Integer::sum);
    }
}
