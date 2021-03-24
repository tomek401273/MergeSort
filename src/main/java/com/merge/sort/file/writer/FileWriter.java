package com.merge.sort.file.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWriter {
    public void write(List<Integer[]> lines, Path path) {
        cleanOutputFile(path);
        for (Integer[] line : lines) {
            String lineString = Arrays.stream(line).map(Object::toString).collect(Collectors.joining(", "));
            lineString += "\n";
            try {
                Files.writeString(path, lineString, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void cleanOutputFile(Path path) {
        try {
            Files.writeString(path, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
