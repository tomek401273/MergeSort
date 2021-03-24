package com.merge.sort.file.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<String> getInputLines(Path inputFilePath) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(inputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
