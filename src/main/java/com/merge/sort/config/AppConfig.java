package com.merge.sort.config;

import com.merge.sort.file.validator.FileExistValidator;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AppConfig {
    private final Path root = Paths.get("src/main/resources");
    private final Path inputFilePath;
    private final Path outputFilePath;
    private final FileExistValidator fileExistValidator;
    private boolean inputFileCorrect;
    private boolean outputFileCorrect;

    public AppConfig(String inputStringPath, String outStringPath) {
        fileExistValidator = new FileExistValidator();
        inputFilePath = root.resolve(inputStringPath);
        outputFilePath = root.resolve(outStringPath);
        // sprawdznie czy isnieje input
        inputFileCorrect = fileExistValidator.isValid(inputFilePath.toString());
        // sprawdznie czy isnieje output
        outputFileCorrect = fileExistValidator.isValid(outputFilePath.toString());
    }

    public Path getInputFilePath() {
        return inputFilePath;
    }

    public Path getOutputFilePath() {
        return outputFilePath;
    }

    public boolean isAppConfigValid() {
        if (!inputFileCorrect) {
            System.out.println("Dear user input file does not exist!");
        }
        if (!outputFileCorrect) {
            System.out.println("Dear user out file does not exist!");
        }
        return inputFileCorrect && outputFileCorrect;
    }
}
