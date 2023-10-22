package edu.project1;

import edu.hw1.EvenArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
    @Test
    public void afterMaxAttemptsReturnsDefeatTest () {
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess(hangman.getSession(), "z");
        hangman.tryGuess(hangman.getSession(), "c");
        hangman.tryGuess(hangman.getSession(), "f");
        hangman.tryGuess(hangman.getSession(), "d");
        States currentState = hangman.tryGuess(hangman.getSession(), "h").state();
        assertEquals(currentState, States.DEFEAT);
    }

    @Test
    public void incorrectLetterInputTest() {
        ConsoleHangman hangman = new ConsoleHangman();
        States currentState = hangman.tryGuess(hangman.getSession(), "ff").state();
        assertEquals(currentState, States.INCORRECT_INPUT);
    }

    @Test
    public void incorrectInputWithCheckedLetterTest() {
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess(hangman.getSession(), "f");
        States currentState = hangman.tryGuess(hangman.getSession(), "f").state();
        assertEquals(currentState, States.INCORRECT_INPUT);
    }

    @Test
    public void correctChangesAttemptsAfterWrongLetterTest() {
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess(hangman.getSession(),"z");
        assertEquals(hangman.getSession().getAttempts(), 1);
    }

    @Test
    public void correctChangesAttemptsAfterRightLetterTest() {
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess(hangman.getSession(),"r");
        hangman.tryGuess(hangman.getSession(),"w");
        assertEquals(hangman.getSession().getAttempts(), 1);
    }
}
