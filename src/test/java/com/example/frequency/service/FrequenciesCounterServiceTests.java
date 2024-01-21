package com.example.frequency.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FrequenciesCounterServiceTests {
    @Autowired
    private FrequenciesCounterService frequenciesCounter;

    @Test
    void ifEmptyReturnsEmpty() {
        String result = frequenciesCounter.count("");
        Assertions.assertEquals("", result);

    }

    @Test
    void returnsSortedByFrequency() {
        String result = frequenciesCounter.count("aaaaabcccc");
        Assertions.assertEquals("\"a\": 5, \"c\": 4, \"b\": 1", result);
    }
}
