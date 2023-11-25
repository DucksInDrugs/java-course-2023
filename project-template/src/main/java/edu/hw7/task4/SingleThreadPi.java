package edu.hw7.task4;

import java.util.Random;

public class SingleThreadPi {
    @SuppressWarnings("MagicNumber")
    public double calculate(long countIterations) {
        long circleCount = 0;

        Random random = new Random();

        for (long i = 0; i < countIterations; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();

            if (x * x + y * y <= 1) {
                circleCount++;
            }
        }
        return 4.0 * (circleCount / (double) countIterations);
    }
}
