package edu.hw5;

public class Task8 {
    public boolean isOddLength(String input) {
        return input.matches("^(1|0)((1|0){2})*$");
    }

    public boolean isOddLengthWithZeroOrEven(String input) {
        return input.matches("^0((1|0){2})*$|^1(1|0)((1|0){2})*$");
    }

    public boolean isStringNotEquals11And111(String input) {
        return input.matches("^(?!11$|111$)[01]+$");
    }

    public boolean isOddSymbolOne(String input) {
        return input.matches("(?:1[10]?)+");
    }
}
