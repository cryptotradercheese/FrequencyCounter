package com.example.frequency.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FrequenciesCounterService {
    public String count(String s) {
        if (s.isEmpty()) {
            return "";
        }

        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
        }

        String result = counts.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry<Character, Integer>::getValue).reversed())
                .map(e -> "\"" + e.getKey() + "\": " + e.getValue() + ", ").collect(Collectors.joining());
        return result.substring(0, result.length() - 2);
    }
}
