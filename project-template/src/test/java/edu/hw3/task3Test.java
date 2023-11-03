package edu.hw3;

import edu.hw3.task3.WordsFrequency;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class task3Test {
    @Test
    public void freqDictWithCorrectInputReturnsCorrectAnswerTest() {
        assertEquals(new WordsFrequency().freqDict(List.of("a", "bb", "a", "bb")),
            Map.of("bb", 2, "a", 2));
        assertEquals(new WordsFrequency().freqDict(List.of("this", "and", "that", "and")),
            Map.of("that", 1, "and", 2, "this", 1));
        assertEquals(new WordsFrequency().freqDict(List.of("код", "код", "код", "bug")),
            Map.of("код", 3, "bug", 1));
        assertEquals(new WordsFrequency().freqDict(List.of(1, 1, 2, 2)),
            Map.of(1, 2, 2, 2));
    }

    @Test
    public void freqDictWithNullInputReturnsNullTest() {
        assertNull(new WordsFrequency().freqDict(null));
    }

    @Test
    public void freqDictWithEmptyInputListReturnsEmptyMapTest() {
        assertEquals(new WordsFrequency().freqDict(List.of()), Map.of());
    }
}
