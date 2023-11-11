package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class task4Test {
    @Test
    public void isStrongPasswordWithTrueAnswerTest() {
        assertTrue(new Task4().isStrongPassword("~!@#$%^&*|"));
        assertTrue(new Task4().isStrongPassword("11@11"));
        assertTrue(new Task4().isStrongPassword("&_(&^!#"));
    }

    @Test
    public void isStrongPasswordWithFalseAnswerTest() {
        assertFalse(new Task4().isStrongPassword("1234567890"));
        assertFalse(new Task4().isStrongPassword(""));
    }
}
