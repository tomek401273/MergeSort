package com.merge.sort.file.writer;

import com.merge.sort.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriterPerson {
    public void write(List<Person> lines, Path path) {
        cleanOutputFile(path);
        for (Person line : lines) {
            String lineString = line.toString();
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
