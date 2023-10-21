package edu.hw2;

import edu.hw2.task4.Calling;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    public void callingInfoTest() {
        assertEquals("callingInfoTest", Calling.callingInfo().methodName());
        assertEquals("edu.hw2.Task4Test", Calling.callingInfo().className());
    }
}
