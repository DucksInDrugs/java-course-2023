package edu.hw3;

import edu.hw3.task2.BracketsClustering;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class task2Test {
    @Test
    public void clusterizeWithCorrectStringReturnsCorrectAnswerTest() {
        assertEquals(new BracketsClustering().clusterize("()()()"), List.of("()", "()", "()"));
        assertEquals(new BracketsClustering().clusterize("((()))"), List.of("((()))"));
        assertEquals(new BracketsClustering().clusterize("((()))(())()()(()())"),
            List.of("((()))", "(())", "()", "()", "(()())"));
        assertEquals(new BracketsClustering().clusterize("((())())(()(()()))"),
            List.of("((())())", "(()(()()))"));
    }

    @Test
    public void clusterizeWithIncorrectStringReturnsNullTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BracketsClustering().clusterize("())");
        });
    }
}
