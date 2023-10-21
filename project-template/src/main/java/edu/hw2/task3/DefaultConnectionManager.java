package edu.hw2.task3;

import java.util.concurrent.ThreadLocalRandom;

public class DefaultConnectionManager implements ConnectionManager {
    @Override
    @SuppressWarnings("MagicNumber")
    public Connection getConnection() {
        if (ThreadLocalRandom.current().nextInt(0, 4) == 0) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
