package edu.hw6.task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PortScanner {
    private static final Map<Integer, String> POPULAR_PORTS = Map.ofEntries(
        Map.entry(80, "HTTP"),
        Map.entry(21, "FTP"),
        Map.entry(25, "SMTP"),
        Map.entry(22, "SSH"),
        Map.entry(443, "HTTPS"),
        Map.entry(53, "DNS")
    );

    public static String getPortDescription(int value) {
        String result = POPULAR_PORTS.get(value);
        return Objects.requireNonNullElse(result, "");
    }

    @SuppressWarnings("MagicNumber")
    public List<PortInfo> scanPorts() {
        List<PortInfo> ports = new ArrayList<>();

        for (int i = 0; i <= 49151; i++) {
            try {
                ServerSocket serverSocket = new ServerSocket(i);
                serverSocket.close();
            } catch (IOException e) {
                ports.add(new PortInfo("TCP", i, getPortDescription(i)));
            }

            try {
                DatagramSocket datagramSocket = new DatagramSocket(i);
                datagramSocket.close();
            } catch (IOException e) {
                ports.add(new PortInfo("UDP", i, getPortDescription(i)));
            }

        }
        return ports;
    }



    public static void print(List<PortInfo> ports) {
        Logger logger = LogManager.getLogger();
        logger.info(String.format("%-10s %-8s %s%n", "Протокол", "Порт", "Сервис"));
        ports.forEach(port -> logger.info(String.format(
            "%-10s %-8d %s%n",
            port.protocol(),
            port.port(),
            port.service()
        )));
    }
}
