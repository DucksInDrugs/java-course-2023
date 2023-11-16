package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class task8Test {
    @Test
    public void isOddLengthWithTrueAnswerTest() {
        assertTrue(new Task8().isOddLength("1"));
        assertTrue(new Task8().isOddLength("0"));
        assertTrue(new Task8().isOddLength("110100010"));
        assertTrue(new Task8().isOddLength("000"));
    }

    @Test
    public void isOddLengthWithFalseAnswerTest() {
        assertFalse(new Task8().isOddLength(""));
        assertFalse(new Task8().isOddLength("10"));
        assertFalse(new Task8().isOddLength("2"));
        assertFalse(new Task8().isOddLength("10201"));
    }

    @Test
    public void isOddLengthWithZeroOrEvenWithTrueAnswerTest() {
        assertTrue(new Task8().isOddLengthWithZeroOrEven("11"));
        assertTrue(new Task8().isOddLengthWithZeroOrEven("0"));
        assertTrue(new Task8().isOddLengthWithZeroOrEven("000"));
    }

    @Test
    public void isOddLengthWithZeroOrEvenWithFalseAnswerTest() {
        assertFalse(new Task8().isOddLengthWithZeroOrEven(""));
        assertFalse(new Task8().isOddLengthWithZeroOrEven("1"));
        assertFalse(new Task8().isOddLengthWithZeroOrEven("00"));
        assertFalse(new Task8().isOddLengthWithZeroOrEven("02"));
        assertFalse(new Task8().isOddLengthWithZeroOrEven("121"));
    }

    @Test
    public void isStringNotEquals11And111WithTrueAnswerTest() {
        assertTrue(new Task8().isStringNotEquals11And111("1"));
        assertTrue(new Task8().isStringNotEquals11And111("101"));
    }

    @Test
    public void isStringNotEquals11And111WithFalseAnswerTest() {
        assertFalse(new Task8().isStringNotEquals11And111("11"));
        assertFalse(new Task8().isStringNotEquals11And111("111"));
        assertFalse(new Task8().isStringNotEquals11And111(""));
        assertFalse(new Task8().isStringNotEquals11And111("2"));
    }

    @Test
    public void isOddSymbolOneWithTrueAnswerTest() {
        assertTrue(new Task8().isOddSymbolOne("10"));
        assertTrue(new Task8().isOddSymbolOne("1"));
        assertTrue(new Task8().isOddSymbolOne("111"));
    }

    @Test
    public void isOddSymbolOneWithFalseAnswerTest() {
        assertFalse(new Task8().isOddSymbolOne("100"));
        assertFalse(new Task8().isOddSymbolOne("001"));
        assertFalse(new Task8().isOddSymbolOne(""));
        assertFalse(new Task8().isOddSymbolOne("121"));
    }
}
