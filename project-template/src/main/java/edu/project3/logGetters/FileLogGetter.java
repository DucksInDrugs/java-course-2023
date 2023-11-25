package edu.project3.logGetters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLogGetter implements LogGetter {
    private final String path;
    private List<String> records;
    private List<String> names;

    public FileLogGetter(String path) {
        this.path = path;
        records = new ArrayList<>();
        names = new ArrayList<>();
        parse();
    }

    public void parse() {
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());
            paths.forEach(path -> {
                names.add(path.getFileName().toString());
                readFile(path);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFile(Path path) {
        try {
            records.addAll(Files.lines(path).toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getRecords() {
        return records;
    }

    @Override
    public List<String> getNames() {
        return names;
    }
}
