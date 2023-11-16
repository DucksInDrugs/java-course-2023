package edu.hw5;

public class Task7 {
    public boolean isAtLeastThreeSymbolsAndThirdZero(String input) {
        return input.matches("^(0|1){2}0(0|1)*$");
    }

    public boolean isStartsAndEndsWithSameSymbol(String input) {
        return input.matches("^(0|1).*\\1$|^0$|^1$");
    }

    public boolean isLengthMoreOneLessFour(String input) {
        return input.matches("^(0|1){1,3}$");
    }
}
