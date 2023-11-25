package edu.hw6;

import edu.hw6.task5.HackerNews;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class task5test {
    @Test
    public void newsWithCorrectIdTest() {
        String expected = "JDK 21 Release Notes";
        assertEquals(expected, new HackerNews().news(37570037));
    }

    @Test
    public void newsWithIncorrectIdTest() {
        assertNull(new HackerNews().news(-1));
    }

    @Test
    public void hackerNewsTopStoriesTest() {
        assertNotNull(new HackerNews().hackerNewsTopStories());
    }
}
