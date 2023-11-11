package edu.hw5.task3;

import java.time.LocalDate;

public class DateTimeParseType5 extends DateTimeParser {
    @Override
    public LocalDate tryParse(String input) {
        if (input.equals("tomorrow")) {
            return LocalDate.now().plusDays(1);
        } else {
            return nextParser.tryParse(input);
        }
    }
}
