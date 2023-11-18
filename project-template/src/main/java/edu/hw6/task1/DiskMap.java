package edu.hw6.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class DiskMap extends HashMap<String, String> implements Map<String, String> {
    private final String fileName;

    public DiskMap(String fileName) {
        this.fileName = fileName;
    }

    public boolean save() {
        File saveFile = new File(fileName);
        if (saveFile.canWrite()) {
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName))) {
                forEach((key, value) -> printWriter.println(key + "=" + value));
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public boolean load() {
        File readFile = new File(fileName);
        if (readFile.exists() && readFile.isFile() && readFile.canRead()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                bufferedReader.lines()
                    .map(line -> line.split("="))
                    .forEach(line -> put(line[0], line[1]));
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
