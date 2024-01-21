package com.example.frequency.controller;

import com.example.frequency.service.FrequenciesCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    private FrequenciesCounterService frequenciesCounter;

    @Autowired
    public ApiController(FrequenciesCounterService frequenciesCounter) {
        this.frequenciesCounter = frequenciesCounter;
    }

    @GetMapping("/frequency")
    public String countFrequencies(@RequestParam(name = "s") String s) {
        return frequenciesCounter.count(s);
    }
}
