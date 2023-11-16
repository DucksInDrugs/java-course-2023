package edu.hw5.task3;

import java.time.LocalDate;

public class DateTimeParseType6 extends DateTimeParser {
    @Override
    public LocalDate tryParse(String input) {
        if (input.equals("today")) {
            return LocalDate.now();
        } else {
            return nextParser.tryParse(input);
        }
    }
}
