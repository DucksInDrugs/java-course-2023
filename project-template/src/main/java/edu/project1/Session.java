package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class Session {
    private final String answer;
    private int attempts;
    private String userAnswer;

    private static final String[] WORDS = {"gallows", "joker", "rogue", "burn"};
    private static final int MAX_ATTEMPTS = 5;

    public Session() {
        answer = WORDS[new Random().nextInt(WORDS.length)];
        attempts = 0;
        userAnswer = "*".repeat(answer.length());
    }

    public int getAttempts() {
        return attempts;
    }

    public @NotNull GuessResult guess(@NotNull Character letter) {
        if (answer.contains(letter.toString())) {
            StringBuilder updatedUserAnswer = new StringBuilder(userAnswer);
            for (int i = 0; i < this.answer.length(); i++) {
                if (this.answer.charAt(i) == letter) {
                    updatedUserAnswer.setCharAt(i, letter);
                }
            }
            userAnswer = updatedUserAnswer.toString();
            if (this.userAnswer.contains("*")) {
                return new GuessResult.SuccessfulGuess();
            } else {
                return new GuessResult.Win();
            }
        } else {
            attempts += 1;
            if (attempts == MAX_ATTEMPTS) {
                return new GuessResult.Defeat(attempts, MAX_ATTEMPTS);
            } else {
                return new GuessResult.FailedGuess(attempts, MAX_ATTEMPTS);
            }
        }
    }

    public String getUserAnswer() {
        return String.format("The word: %s", userAnswer);
    }
}
