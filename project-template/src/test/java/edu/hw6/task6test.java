package edu.hw6;

import edu.hw6.task6.PortInfo;
import edu.hw6.task6.PortScanner;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class task6test {
    @Test
    public void scanPortsTest() {
        List<PortInfo> portInfoList = new PortScanner().scanPorts();
        assertNotNull(portInfoList);
    }
}
