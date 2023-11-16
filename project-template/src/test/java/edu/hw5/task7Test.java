package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class task7Test {
    @Test
    public void isAtLeastThreeSymbolsAndThirdZeroWithTrueAnswerTest() {
        assertTrue(new Task7().isAtLeastThreeSymbolsAndThirdZero("100"));
        assertTrue(new Task7().isAtLeastThreeSymbolsAndThirdZero("1001101"));
    }

    @Test
    public void isAtLeastThreeSymbolsAndThirdZeroWithFalseAnswerTest() {
        assertFalse(new Task7().isAtLeastThreeSymbolsAndThirdZero(""));
        assertFalse(new Task7().isAtLeastThreeSymbolsAndThirdZero("2"));
        assertFalse(new Task7().isAtLeastThreeSymbolsAndThirdZero("101"));
    }

    @Test
    public void isStartsAndEndsWithSameSymbolWithTrueAnswerTest() {
        assertTrue(new Task7().isStartsAndEndsWithSameSymbol("1"));
        assertTrue(new Task7().isStartsAndEndsWithSameSymbol("11"));
    }

    @Test
    public void isStartsAndEndsWithSameSymbolWithFalseAnswerTest() {
        assertFalse(new Task7().isStartsAndEndsWithSameSymbol(""));
        assertFalse(new Task7().isStartsAndEndsWithSameSymbol("10"));
        assertFalse(new Task7().isStartsAndEndsWithSameSymbol("2"));
    }

    @Test
    public void isLengthMoreOneLessFourWithTrueAnswerTest() {
        assertTrue(new Task7().isLengthMoreOneLessFour("1"));
        assertTrue(new Task7().isLengthMoreOneLessFour("11"));
        assertTrue(new Task7().isLengthMoreOneLessFour("111"));
    }

    @Test
    public void isLengthMoreOneLessFourWithFalseAnswerTest() {
        assertFalse(new Task7().isLengthMoreOneLessFour(""));
        assertFalse(new Task7().isLengthMoreOneLessFour("2"));
        assertFalse(new Task7().isLengthMoreOneLessFour("1111"));
    }
}
