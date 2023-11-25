package edu.hw7.task2;

import java.util.stream.LongStream;

public class Factorial {
    public long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        return LongStream.rangeClosed(1, n)
            .parallel()
            .reduce(1, (a, b) -> a * b);
    }
}
