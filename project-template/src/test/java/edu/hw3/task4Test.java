package edu.hw3;

import edu.hw3.task4.RomanNumbersConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class task4Test {
    @Test
    public void convertToRomanWithCorrectInputReturnsCorrectAnswerTest() {
        assertEquals(new RomanNumbersConverter().convertToRoman(2), "II");
        assertEquals(new RomanNumbersConverter().convertToRoman(12), "XII");
        assertEquals(new RomanNumbersConverter().convertToRoman(16), "XVI");
        assertEquals(new RomanNumbersConverter().convertToRoman(0), "");
    }

    @Test
    public void convertToRomanWithInputLessThanZeroReturnsNullTest() {
        assertNull(new RomanNumbersConverter().convertToRoman(-5));
    }
}
