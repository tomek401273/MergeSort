package com.merge.sort.config;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AppConfig {
    private static Path root = Paths.get("src/main/resources");
    private static Path inputFilePath;
    private static Path outputFilePath;

    public static void setInputFilePath(String stringPath) {
        inputFilePath = root.resolve(stringPath);
    }

    public static void setOutputFilePath(String stringPath) {
        outputFilePath = root.resolve(stringPath);
    }

    public static Path getInputFilePath() {
        return inputFilePath;
    }

    public static Path getOutputPath() {
        return outputFilePath;
    }


}
