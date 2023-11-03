package edu.hw3;

import edu.hw3.task7.TreeMapNullComparator;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class task7Test {
    @Test
    public void testingThatCodeIsWorking() {
        TreeMap<String, String> tree = new TreeMap<>(new TreeMapNullComparator<>());

        assertDoesNotThrow(() -> tree.put(null, "test"));
        assertTrue(tree.containsKey(null));
    }
}
