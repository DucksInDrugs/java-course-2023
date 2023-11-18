package edu.hw6;

import edu.hw6.task4.Composition;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class task4test {
    @Test
    public void makeTest() {
        List<String> rows;
        new Composition().make("task4test");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("task4test"))) {
            rows = bufferedReader.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals("Programming is learned by writing programs. ― Brian Kernighan", rows.get(0));
        assertEquals(1, rows.size());
    }
}
