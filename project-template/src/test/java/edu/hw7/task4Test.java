package edu.hw7;

import edu.hw7.task4.MultiThreadPi;
import edu.hw7.task4.SingleThreadPi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class task4Test {
    @Test
    public void singleThreadPiCalculateTest() {
        assertEquals(Math.PI, new SingleThreadPi().calculate(1000000000), 0.001);
    }

    @Test
    public void multiThreadPiCalculateTest() {
        assertEquals(Math.PI, new MultiThreadPi().calculate(4, 1000000000), 0.001);
    }
}
