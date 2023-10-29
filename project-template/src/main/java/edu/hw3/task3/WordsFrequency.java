package edu.hw3.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsFrequency {
    public <T> Map<T, Integer> freqDict(List<T> input) {
        if (input == null) {
            return null;
        }
        Map<T, Integer> frequency = new HashMap<>();
        for (T element: input) {
            if (frequency.containsKey(element)) {
                frequency.put(element, frequency.get(element) + 1);
            } else {
                frequency.put(element, 1);
            }
        }
        return frequency;
    }
}
