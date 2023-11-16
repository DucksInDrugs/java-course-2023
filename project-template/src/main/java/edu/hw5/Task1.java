package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {
    @SuppressWarnings("MagicNumber")
    public String getAVGDuration(List<String> sessions) {
        if (sessions.isEmpty()) {
            return "0ч 0м";
        }
        Duration duration = Duration.ZERO;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        for (String session : sessions) {
            String[] interval = session.split(" - ");
            LocalDateTime start = LocalDateTime.parse(interval[0], dateTimeFormatter);
            LocalDateTime end = LocalDateTime.parse(interval[1], dateTimeFormatter);
            duration = duration.plus(Duration.between(start, end));
        }
        long minutes = duration.dividedBy(sessions.size()).toMinutes();
        return String.format("%dч %dм", minutes / 60, minutes % 60);
    }
}
