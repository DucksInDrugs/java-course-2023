package edu.hw4;

import java.util.Objects;

public class ValidationError {
    private final String message;
    private final ValidationErrorType type;

    public ValidationError(String message, ValidationErrorType type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj.getClass() != ValidationError.class) {
            return false;
        }
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, type);
    }
}
