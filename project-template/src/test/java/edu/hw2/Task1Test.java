package edu.hw2;

import edu.hw2.task1.Expr.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    public void constantTestReturnsCorrectAnswer() {
        assertEquals(2, new Constant(2).evaluate());
    }

    @Test
    public void negateTestReturnsCorrectAnswer(){
        assertEquals(-1, new Negate(new Constant(1)).evaluate());
        assertEquals(1, new Negate(new Constant(-1)).evaluate());
    }

    @Test
    public void exponentTestReturnsCorrectAnswer(){
        assertEquals(9, new Exponent(new Constant(3), 2).evaluate());
        assertEquals(-27, new Exponent(new Constant(-3), 3).evaluate());
        assertEquals(1, new Exponent(new Constant(3), 0).evaluate());
    }

    @Test
    public void additionTestReturnsCorrectAnswer(){
        assertEquals(4, new Addition(new Constant(3), new Constant(1)).evaluate());
        assertEquals(2, new Addition(new Constant(3), new Constant(-1)).evaluate());
    }

    @Test
    public void multiplicationTestReturnsCorrectAnswer(){
        assertEquals(6, new Multiplication(new Constant(3), new Constant(2)).evaluate());
        assertEquals(-6, new Multiplication(new Constant(3), new Constant(-2)).evaluate());
    }
}
