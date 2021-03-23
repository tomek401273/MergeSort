package com.merge.sort.parser;

import com.merge.sort.file.parser.FileParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FileParserTest {

    @Test
    void parse() {
        // given
        List<String> inputList = new ArrayList<>();
        inputList.add("1 20 5 10 12 14 16 25");
        inputList.add("2 5 10 22 40 1 7 15");
        inputList.add("12 101 1 12");
        // when
        FileParser fileParser= new FileParser();
        List<Integer[]> result = fileParser.parse(inputList);
        System.out.println(result);
        // then
    }
}