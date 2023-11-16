package edu.hw5.task3;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTimeParseType9 extends DateTimeParser {
    @Override
    public LocalDate tryParse(String input) {
        Pattern pattern = Pattern.compile("^[0-9]{1,} days ago$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            int days = Integer.parseInt(input.split(" ")[0]);
            return LocalDate.now().minusDays(days);
        } else {
            return null;
        }
    }
}
