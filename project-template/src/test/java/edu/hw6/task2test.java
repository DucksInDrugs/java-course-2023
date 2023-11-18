package edu.hw6;

import edu.hw6.task2.CopyFile;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class task2test {
    @Test
    public void cloneFileTest() {
        new CopyFile().cloneFile(Path.of("task2test.txt"));
        assertTrue(Files.exists(Path.of("task2test.txt")));
        assertTrue(Files.exists(Path.of("task2test - копия.txt")));
    }
}
