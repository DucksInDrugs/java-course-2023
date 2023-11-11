package edu.hw5;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class task1Test {
    @Test
    public void getAVGDurationWithCorrectInputTest() {
        assertEquals("3ч 40м", new Task1().getAVGDuration(List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20")));
    }

    @Test
    public void getAVGDurationWithEmptyInputTest() {
        assertEquals("0ч 0м", new Task1().getAVGDuration(List.of()));
    }
}
