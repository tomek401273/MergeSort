package com.merge.sort.config;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AppConfig {
    private static Path inputFile = Paths.get("src/main/resources");

    public static Path getInputFilePath(){
        return inputFile.resolve("input/test/input-test1.txt");
    }

    public static Path getOutputPath(){
        return inputFile.resolve("output/test/output-test1.txt");
    }


}
