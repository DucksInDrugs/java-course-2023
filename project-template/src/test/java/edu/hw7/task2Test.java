package edu.hw7;

import edu.hw7.task2.Factorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class task2Test {
    @Test
    public void calculateFactorialReturnsCorrectValue() {
        assertEquals(1, new Factorial().calculate(0));
        assertEquals(1, new Factorial().calculate(1));
        assertEquals(2, new Factorial().calculate(2));
        assertEquals(6, new Factorial().calculate(3));
        assertEquals(24, new Factorial().calculate(4));
        assertEquals(120, new Factorial().calculate(5));
        assertEquals(720, new Factorial().calculate(6));
        assertEquals(5040, new Factorial().calculate(7));
        assertEquals(40320, new Factorial().calculate(8));
        assertEquals(362880, new Factorial().calculate(9));
        assertEquals(3628800, new Factorial().calculate(10));
    }

    @Test
    public void calculateFactorialWithIncorrectValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Factorial().calculate(-1));
    }
}
