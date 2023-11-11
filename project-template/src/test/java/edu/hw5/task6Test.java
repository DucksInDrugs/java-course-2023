package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class task6Test {
    @Test
    public void isSubstringWithTrueAnswerTest() {
        assertTrue(new Task6().isSubstring("abc", "achfdbaabgabcaabg"));
    }

    @Test
    public void isSubstringWithFalseAnswerTest() {
        assertFalse(new Task6().isSubstring("1", "achfdbaabgabcaabg"));
    }
}
