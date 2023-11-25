package edu.hw6.task3;

import java.nio.file.Files;

public class Filters {

    private Filters() {
    }

    public static AbstractFilter largerThan(int input) {
        return path -> Files.size(path) > input;
    }

    public static AbstractFilter magicNumber(int... ints) {
        return path -> {
            byte[] bytes = Files.readAllBytes(path);
            if (bytes.length < ints.length) {
                return false;
            }
            for (int i = 0; i < ints.length; i++) {
                if (bytes[i] != ints[i]) {
                    return false;
                }
            }
            return true;
        };
    }

    public static AbstractFilter globMatches(String input) {
        return path -> path.getFileSystem().getPathMatcher("glob:" + input).matches(path.getFileName());
    }

    public static AbstractFilter regexContains(String input) {
        return path -> path.getFileName().toString().matches(".*" + input + ".*");
    }
}
