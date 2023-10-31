package edu.hw2;

import edu.hw2.task3.*;
import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    private static final int TEST_ITERATIONS = 1000;

    @Test
    public void faultyConnectionManagerAlwaysReturnsFaultyConnectionTest() {
        assertTrue(IntStream.range(0, TEST_ITERATIONS)
            .mapToObj(iteration -> new FaultyConnectionManager())
            .allMatch(manager -> manager.getConnection() instanceof FaultyConnection));
    }

    @Test
    public void defaultConnectionManagerCanReturnStableConnectionTest() {
        assertTrue(IntStream.range(0, TEST_ITERATIONS)
            .mapToObj(iteration -> new DefaultConnectionManager())
            .anyMatch(manager -> manager.getConnection() instanceof StableConnection));
    }

    @Test
    public void defaultConnectionManagerCanReturnFaultyConnectionTest() {
        assertTrue(IntStream.range(0, TEST_ITERATIONS)
            .mapToObj(iteration -> new DefaultConnectionManager())
            .anyMatch(manager -> manager.getConnection() instanceof FaultyConnection));
    }

    @Test
    public void stableConnectionNeverThrowExceptionTest() {
        IntStream.range(0, TEST_ITERATIONS)
            .mapToObj(iteration -> new StableConnection())
            .forEach(connection -> assertDoesNotThrow(() -> connection.execute("")));
    }
}
