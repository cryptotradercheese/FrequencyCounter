package com.example.frequency.controller;

import com.example.frequency.service.FrequenciesCounterService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@WebMvcTest(ApiController.class)
public class ApiControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FrequenciesCounterService frequenciesCounter;

    @Test
    void returnsResultOfFrequencyCounterWithOkStatus() throws Exception {
        Mockito.when(frequenciesCounter.count(ArgumentMatchers.anyString())).thenReturn("result");
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/api/frequency?s=someString")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("result"));
    }
}
