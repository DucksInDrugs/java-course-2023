package edu.hw6.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private final String fileName;
    private final Map<String, String> map;

    public DiskMap(String fileName) {
        this.fileName = fileName;
        map = new HashMap<>();
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

    @Override
    public int size() {
        load();
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        load();
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        load();
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        load();
        return map.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        String previousValue = map.put(key, value);
        save();
        return previousValue;
    }

    @Override
    public String remove(Object key) {
        load();
        String removedValue = map.remove(key);
        save();
        return removedValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        load();
        map.putAll(m);
        save();
    }

    @Override
    public void clear() {
        load();
        map.clear();
        save();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        load();
        return map.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        load();
        return map.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        load();
        return map.entrySet();
    }
}
