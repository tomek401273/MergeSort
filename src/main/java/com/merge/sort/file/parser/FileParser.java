package com.merge.sort.file.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileParser {
    public List<Integer[]> parse(List<String> lines){
        List<Integer[]> result = new ArrayList<>();
        for (String line:lines) {
            String[] splits = line.split(" ");
            Integer[] parsedLine = parseLine(splits);
            result.add(parsedLine);
        }
        return result;
    }

    public Integer[] parseLine(String[] splits){
        Integer[] integers =new Integer[splits.length];
        for (int i = 0; i <splits.length ; i++) {
            integers[i]=(Integer.valueOf(splits[i]));
        }
        return integers;
    }


}
