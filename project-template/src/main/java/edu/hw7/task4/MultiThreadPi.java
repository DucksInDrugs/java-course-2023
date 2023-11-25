package edu.hw7.task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public class MultiThreadPi {
    private static final AtomicLong CIRCLE_COUNT = new AtomicLong(0);
    private static final AtomicLong TOTAL_COUNT = new AtomicLong(0);

    @SuppressWarnings("MagicNumber")
    public double calculate(int numThreads, long countIterations) {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        for (int i = 0; i < numThreads; i++) {
            long localCircleCount = 0;
            long localTotalCount = 0;
            ThreadLocalRandom random = ThreadLocalRandom.current();

            for (long j = 0; j < countIterations; j++) {
                double x = random.nextDouble();
                double y = random.nextDouble();
                if (x * x + y * y <= 1) {
                    localCircleCount++;
                }
                localTotalCount++;
            }

            CIRCLE_COUNT.addAndGet(localCircleCount);
            TOTAL_COUNT.addAndGet(localTotalCount);
        }
        executor.shutdown();
        return 4.0 * CIRCLE_COUNT.get() / (double) TOTAL_COUNT.get();
    }
}
