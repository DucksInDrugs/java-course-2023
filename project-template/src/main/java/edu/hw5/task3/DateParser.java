package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class DateParser {
    public Optional<LocalDate> parseDate(String string) {
        if (string == null || string.isEmpty()) {
            return Optional.empty();
        }
        DateTimeParseType1 dateTimeParseType1 = new DateTimeParseType1();
        DateTimeParseType2 dateTimeParseType2 = new DateTimeParseType2();
        DateTimeParseType3 dateTimeParseType3 = new DateTimeParseType3();
        DateTimeParseType4 dateTimeParseType4 = new DateTimeParseType4();
        DateTimeParseType5 dateTimeParseType5 = new DateTimeParseType5();
        DateTimeParseType6 dateTimeParseType6 = new DateTimeParseType6();
        DateTimeParseType7 dateTimeParseType7 = new DateTimeParseType7();
        DateTimeParseType8 dateTimeParseType8 = new DateTimeParseType8();
        DateTimeParseType9 dateTimeParseType9 = new DateTimeParseType9();

        dateTimeParseType1.setNextParser(dateTimeParseType2);
        dateTimeParseType2.setNextParser(dateTimeParseType3);
        dateTimeParseType3.setNextParser(dateTimeParseType4);
        dateTimeParseType4.setNextParser(dateTimeParseType5);
        dateTimeParseType5.setNextParser(dateTimeParseType6);
        dateTimeParseType6.setNextParser(dateTimeParseType7);
        dateTimeParseType7.setNextParser(dateTimeParseType8);
        dateTimeParseType8.setNextParser(dateTimeParseType9);

        LocalDate parsed = dateTimeParseType1.tryParse(string);
        return Optional.ofNullable(parsed);
    }
}
