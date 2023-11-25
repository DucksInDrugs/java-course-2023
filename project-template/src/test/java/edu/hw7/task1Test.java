package edu.hw7;

import edu.hw7.task1.Counter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class task1Test {
    @Test
    public void incrementCounterReturnsCorrectValueTest() throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.incrementCounter();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.incrementCounter();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assertEquals(200, counter.getCounter());
    }
}
