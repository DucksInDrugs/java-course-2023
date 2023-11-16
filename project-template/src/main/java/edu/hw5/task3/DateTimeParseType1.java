package edu.hw5.task3;

import java.time.DateTimeException;
import java.time.LocalDate;

public class DateTimeParseType1 extends DateTimeParser {
    @Override
    public LocalDate tryParse(String input) {
        try {
            return LocalDate.parse(input);
        } catch (DateTimeException e) {
            return nextParser.tryParse(input);
        }
    }
}
