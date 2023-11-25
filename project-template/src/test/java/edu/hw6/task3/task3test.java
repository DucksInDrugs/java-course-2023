package edu.hw6.task3;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static edu.hw6.task3.Filters.globMatches;
import static edu.hw6.task3.Filters.largerThan;
import static edu.hw6.task3.Filters.magicNumber;
import static edu.hw6.task3.Filters.regexContains;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class task3test {
    @Test
    public void filterTest() throws IOException {
        Path filePath = Path.of("src", "test", "java", "edu", "hw6", "task3", "data");
        final AbstractFilter readable = Files::isReadable;

        DirectoryStream.Filter<Path> filter = readable
            .and(globMatches("*.jpg"))
            .and(largerThan(50 * 1024))
            .and(regexContains("test"))
            .and(magicNumber(-1));

        List<String> expectedFileNames = List.of("testSizejpg.jpg");
        List<String> actualFileNames = new ArrayList<>();
        var f = Files.readAllBytes(Path.of(filePath.toString(), "testSizejpg.jpg"));
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(filePath, filter)) {
            entries.forEach(entry -> actualFileNames.add(entry.getFileName().toString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expectedFileNames, actualFileNames);
    }
}
