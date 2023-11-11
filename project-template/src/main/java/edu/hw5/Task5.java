package edu.hw5;

public class Task5 {
    public boolean isRussianNumber(String number) {
        return number.matches("^[АВЕКМНОРСТУИХ]{1}\\d{3}[АВЕКМНОРСТУИХ]{2}\\d{2,3}$");
    }
}
