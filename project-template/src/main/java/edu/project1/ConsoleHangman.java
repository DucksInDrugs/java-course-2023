package edu.project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("RegexpSinglelineJava")
public class ConsoleHangman {
    private final Set<Character> receivedLetters = new HashSet<>();
    private final Session session;
    private final static String SURRENDER_WORD = "ff15";

    public ConsoleHangman() {
        this.session = new Session();
    }

    public Session getSession() {
        return session;
    }

    public void run() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("Write \"ff15\" to surrender");
        while (true) {
            System.out.println("Guess a letter:");
            String input = bufferedReader.readLine().toLowerCase();

            if (input.equals(SURRENDER_WORD)) {
                System.out.println("You have given up. Better luck next time");
                break;
            }
            States currentState = tryGuess(session, input).state();

            if (currentState == States.DEFEAT || currentState == States.WIN) {
                break;
            }
        }
    }

    public GuessResult tryGuess(Session session, String input) {
        if (input != null && input.length() == 1 && Character.isAlphabetic(input.charAt(0))
            && !receivedLetters.contains(input.charAt(0))) {
            char letter = input.charAt(0);
            receivedLetters.add(letter);
            GuessResult currentState = session.guess(letter);

            System.out.println(currentState.message());
            System.out.println(session.getUserAnswer());
            return currentState;
        } else {
            GuessResult incorrectInput = new GuessResult.IncorrectInput();
            System.out.println(incorrectInput.message());
            return incorrectInput;
        }
    }
}
