package edu.hw2.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        int attempts = 0;
        ConnectionException exception = null;

        while (attempts < maxAttempts) {
            try {
                manager.getConnection().execute(command);
                break;
            } catch (ConnectionException e) {
                if (++attempts == maxAttempts) {
                    if (exception == null) {
                        exception = e;
                    } else {
                        exception.addSuppressed(e);
                    }
                }
            }
        }

        if (exception != null) {
            throw exception;
        }
    }
}
