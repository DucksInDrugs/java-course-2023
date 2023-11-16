package edu.hw5;

public class Task4 {
    public boolean isStrongPassword(String password) {
        return password.matches(".*[~!@#$%^&*|].*");
    }
}
