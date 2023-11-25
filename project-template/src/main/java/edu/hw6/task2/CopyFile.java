package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFile {
    public void cloneFile(Path path) {
        String directoryPath = path.toAbsolutePath().getParent().toString();
        Path fileName = path.getFileName();
        String[] fileAndExtension = fileName.toString().split("\\.");
        String file = fileAndExtension[0];
        String extension = fileAndExtension[1];
        Path copyOfFile = Paths.get(directoryPath, file + " - копия." + extension);
        int copyCounter = 2;
        while (Files.exists(copyOfFile)) {
            copyOfFile = Paths.get(directoryPath, String.format(file + " - копия (%d)" + extension, copyCounter));
            copyCounter++;
        }
        try {
            Files.copy(path, copyOfFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
