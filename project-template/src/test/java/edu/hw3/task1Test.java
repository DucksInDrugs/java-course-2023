package edu.hw3;

import edu.hw3.task1.Atbash;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class task1Test {
    @Test
    public void atbashReturnsCorrectStringTest() {
        assertEquals(new Atbash().atbash("Hello world!"), "Svool dliow!");
    }

    @Test
    public void atbashReturnsCorrectReversedStringTest() {
        assertEquals(new Atbash().atbash("Svool dliow!"), "Hello world!");
    }

    @Test
    public void atbashWithEmptyInputReturnsEmptyInputTest() {
        assertEquals(new Atbash().atbash(""), "");
    }
}
