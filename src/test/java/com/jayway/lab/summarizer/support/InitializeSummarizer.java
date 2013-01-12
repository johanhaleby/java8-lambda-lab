package com.jayway.lab.summarizer.support;

import com.jayway.lab.summarizer.Summarizer;
import org.junit.Before;

public class InitializeSummarizer {

    protected Summarizer summarizer;

    @Before public void
    given_summer_is_initialized() {
        summarizer = new Summarizer();
    }
}
