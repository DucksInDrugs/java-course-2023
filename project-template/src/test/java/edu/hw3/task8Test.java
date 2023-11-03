package edu.hw3;

import edu.hw3.task8.BackwardIterator;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class task8Test {
    @Test
    public void backwardIteratorReturnsReversedCollectionTest() {
        Iterator<Integer> iterator = new BackwardIterator<>(List.of(1, 2, 3));
        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
    }
}
