package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    @SuppressWarnings("MagicNumber")
    public List<LocalDate> getFridaysTheThirteenth(int year) {
        List<LocalDate> fridaysTheThirteenth = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            LocalDate date = LocalDate.of(year, i, 13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridaysTheThirteenth.add(date);
            }
        }
        return fridaysTheThirteenth;
    }

    @SuppressWarnings("MagicNumber")
    public LocalDate findNextFridayTheThirteenth(LocalDate date) {
        LocalDate answer = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while (answer.getDayOfMonth() != 13) {
            answer = answer.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return answer;
    }
}
