package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class task2Test {
    @Test
    public void getFridaysTheThirteenthWithCorrectInputTest() {
        assertEquals(List.of(LocalDate.of(2024, 9, 13), LocalDate.of(2024, 12, 13)), new Task2().getFridaysTheThirteenth(2024));
    }

    @Test
    public void findNextFridayTheThirteenthWithCorrectInputTest() {
        assertEquals(LocalDate.of(2024, 9, 13), new Task2().findNextFridayTheThirteenth(LocalDate.of(2024, 1, 12)));
    }
}
