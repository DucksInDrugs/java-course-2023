package edu.hw5.task3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeParseType3 extends DateTimeParser {
    @Override
    public LocalDate tryParse(String input) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        try {
            return LocalDate.parse(input, dateTimeFormatter);
        } catch (DateTimeException e) {
            return nextParser.tryParse(input);
        }
    }
}
