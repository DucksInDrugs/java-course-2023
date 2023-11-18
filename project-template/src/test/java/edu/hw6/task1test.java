package edu.hw6;

import edu.hw6.task1.DiskMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class task1test {
    @Test
    public void saveWithValuesTest() {
        DiskMap diskMap = new DiskMap("task1test.txt");
        diskMap.put("testKey", "testValue");
        assertTrue(diskMap.save());
    }

    @Test
    public void saveWithoutExistingFile() {
        DiskMap diskMap = new DiskMap("notExistingFile.txt");
        diskMap.put("smth", "smth");
        assertFalse(diskMap.save());
    }

    @Test
    public void loadWithExistingFile() {
        DiskMap diskMap = new DiskMap("task1test.txt");
        diskMap.load();
        assertEquals("testValue", diskMap.get("testKey"));
    }

    @Test
    public void loadWithoutExistingFile() {
        DiskMap diskMap = new DiskMap("notExistingFile.txt");
        assertFalse(diskMap.load());
    }
}
