package com.merge.sort.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileParser {
    public List<List<Integer>> parse(List<String> lines){
        List<List<Integer>> result = new ArrayList<>();
        for (String line:lines) {
            String[] splits = line.split(" ");
            List<Integer> parsedLine = parseLine(splits);
            result.add(parsedLine);
        }
        return result;
    }

    public List<Integer> parseLine(String[] splits){
        List<Integer> integers= new ArrayList<>();
        for (String split: splits) {
            integers.add(Integer.valueOf(split));
        }
        return integers;
    }


}
