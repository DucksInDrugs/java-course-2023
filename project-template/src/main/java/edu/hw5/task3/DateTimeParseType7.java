package edu.hw5.task3;

import java.time.LocalDate;

public class DateTimeParseType7 extends DateTimeParser {
    @Override
    public LocalDate tryParse(String input) {
        if (input.equals("yesterday")) {
            return LocalDate.now().minusDays(1);
        } else {
            return nextParser.tryParse(input);
        }
    }
}
