package edu.project3;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LogsAnalyzer {
    private String path;
    private LocalDate from;
    private LocalDate to;
    private String format;

    public LogsAnalyzer(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--path" -> path = args[i + 1];
                case "--from" -> from = LocalDate.parse(args[i + 1], DateTimeFormatter.ISO_DATE);
                case "--to" -> to = LocalDate.parse(args[i + 1], DateTimeFormatter.ISO_DATE);
                case "--format" -> format = args[i + 1];
            }
        }
    }

    public void run() {
        if (isURL(path)) {

        } else {

        }
    }

    public boolean isURL(String path) {
        try {
            new URI(path).toURL();
            return true;
        } catch (URISyntaxException | MalformedURLException e) {
            return false;
        }
    }
}
