package edu.hw5.task3;

import java.time.LocalDate;

public abstract class DateTimeParser {
    protected DateTimeParser nextParser;

    public void setNextParser(DateTimeParser nextParser) {
        this.nextParser = nextParser;
    }

    public abstract LocalDate tryParse(String input);
}
