package edu.project1;

import org.jetbrains.annotations.NotNull;

sealed interface GuessResult {
    @NotNull String message();

    @NotNull States state();

    record Defeat(int currentAttempt, int maxAttempts) implements GuessResult {
        @Override
        public @NotNull String message() {
            return String.format("Missed, mistake %d out of %d. \nYou lost!", currentAttempt, maxAttempts);
        }

        @Override
        public @NotNull States state() {
            return States.DEFEAT;
        }
    }

    record Win() implements GuessResult {
        @Override
        public @NotNull String message() {
            return "You won!";
        }

        @Override
        public @NotNull States state() {
            return States.WIN;
        }
    }

    record SuccessfulGuess() implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Hit!";
        }

        @Override
        public @NotNull States state() {
            return States.SUCCESSFUL_GUESS;
        }
    }

    record FailedGuess(int currentAttempt, int maxAttempts) implements GuessResult {
        @Override
        public @NotNull String message() {
            return String.format("Missed, mistake %d out of %d.", currentAttempt, maxAttempts);
        }

        @Override
        public @NotNull States state() {
            return States.FAILED_GUESS;
        }
    }

    record IncorrectInput() implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Incorrect input, retry";
        }

        @Override
        public @NotNull States state() {
            return States.INCORRECT_INPUT;
        }
    }
}
