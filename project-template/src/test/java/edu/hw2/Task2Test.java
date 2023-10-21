package edu.hw2;

import edu.hw2.task2.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    public void rectangleAreaTestCorrectAnswer() {
        Rectangle rectangle = new Rectangle(10, 20);
        assertEquals(200, rectangle.area());
    }

    @Test
    public void rectangleAreaTestCorrectAnswerAfterChangingEdges() {
        Rectangle rectangle = new Rectangle(10, 20);
        rectangle = rectangle.setHeight(20);
        rectangle = rectangle.setWidth(5);
        assertEquals(100, rectangle.area());
    }

    @Test
    public void squareAreaTestCorrectAnswer() {
        Square square = new Square(10);
        assertEquals(100, square.area());
    }

    @Test
    public void squareAreaTestCorrectAnswerAfterChangingHeight() {
        Rectangle square = new Square(10);
        square = square.setHeight(20);
        assertEquals(400, square.area());
    }

    @Test
    public void squareAreaTestCorrectAnswerAfterChangingWidth() {
        Rectangle square = new Square(10);
        square = square.setWidth(20);
        assertEquals(400, square.area());
    }
}
