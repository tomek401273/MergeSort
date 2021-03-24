package com.merge.sort.file.parser;

import com.merge.sort.file.validator.NumberValidator;

import java.util.ArrayList;
import java.util.List;

public class FileParser {
    public List<Integer[]> parse(List<String> lines) {
        NumberValidator numberValidator = new NumberValidator();
        List<Integer[]> result = new ArrayList<>();
        for (String line : lines) {
            String[] splits = line.split(" ");
            Integer[] parsedLine = parseLine(splits, numberValidator);
            result.add(parsedLine);
        }
        return result;
    }

    public Integer[] parseLine(String[] splits, NumberValidator numberValidator) {
        Integer[] integers = new Integer[splits.length];
        for (int i = 0; i < splits.length; i++) {
            String split = splits[i];
            if (numberValidator.isValid(split)) {
                integers[i] = (Integer.valueOf(split));
            } else {
                integers[i] = 0;
            }
        }
        return integers;
    }
}
