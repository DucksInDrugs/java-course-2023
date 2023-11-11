package edu.hw5;

import edu.hw5.task3.DateParser;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class task3test {
    @Test
    public void tryParseWithCorrectInput() {
        assertEquals(Optional.of(LocalDate.now().plusDays(1)) ,new DateParser().parseDate("tomorrow"));
        assertEquals(Optional.of(LocalDate.of(2020, 10, 10)) ,new DateParser().parseDate("2020-10-10"));
        assertEquals(Optional.of(LocalDate.of(2020, 12, 2)) ,new DateParser().parseDate("2020-12-2"));
        assertEquals(Optional.of(LocalDate.of(1976, 3, 1)) ,new DateParser().parseDate("1/3/1976"));
        assertEquals(Optional.of(LocalDate.of(2020, 3, 1)) ,new DateParser().parseDate("1/3/20"));
        assertEquals(Optional.of(LocalDate.now()) ,new DateParser().parseDate("today"));
        assertEquals(Optional.of(LocalDate.now().minusDays(1)) ,new DateParser().parseDate("yesterday"));
        assertEquals(Optional.of(LocalDate.now().minusDays(1)) ,new DateParser().parseDate("1 day ago"));
        assertEquals(Optional.of(LocalDate.now().minusDays(2234)) ,new DateParser().parseDate("2234 days ago"));
    }

    @Test
    public void tryParseWithIncorrectInput() {
        assertEquals(Optional.empty(), new DateParser().parseDate("2morrow"));
        assertEquals(Optional.empty(), new DateParser().parseDate(" days ago"));
        assertEquals(Optional.empty(), new DateParser().parseDate(""));
        assertEquals(Optional.empty(), new DateParser().parseDate(null));
    }
}
