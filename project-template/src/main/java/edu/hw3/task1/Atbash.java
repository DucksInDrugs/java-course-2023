package edu.hw3.task1;

import org.jetbrains.annotations.NotNull;

public class Atbash {
    public String atbash(@NotNull String input) {
        StringBuilder answer = new StringBuilder();
        char[] inputChars = input.toCharArray();
        for (int i = 0; i < inputChars.length; i++) {
            if (Character.isAlphabetic(inputChars[i])) {
                if (inputChars[i] >= 'A' && inputChars[i] <= 'Z') {
                    answer.append((char) ('A' - inputChars[i] + 'Z'));
                } else {
                    answer.append((char) ('a' - inputChars[i] + 'z'));
                }
            } else {
                answer.append(input.charAt(i));
            }
        }
        return new String(answer);
    }
}
