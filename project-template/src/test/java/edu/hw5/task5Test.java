package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class task5Test {
    @Test
    public void isRussianNumberWithTrueAnswer() {
        assertTrue(new Task5().isRussianNumber("А123ВЕ777"));
        assertTrue(new Task5().isRussianNumber("А123ВЕ77"));
    }

    @Test
    public void isRussianNumberWithFalseAnswer() {
        assertFalse(new Task5().isRussianNumber("А123ВЕ7"));
        assertFalse(new Task5().isRussianNumber("А1235ВЕ777"));
        assertFalse(new Task5().isRussianNumber("АА123ВЕ777"));
        assertFalse(new Task5().isRussianNumber("АГ123ВЕ777"));
    }
}
