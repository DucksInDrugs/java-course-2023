package edu.hw2.task3;

import java.util.concurrent.ThreadLocalRandom;

public class FaultyConnection implements Connection {
    @Override
    @SuppressWarnings("MagicNumber")
    public void execute(String command) {
        if (ThreadLocalRandom.current().nextInt(0, 4) == 0) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() throws Exception {
    }
}
