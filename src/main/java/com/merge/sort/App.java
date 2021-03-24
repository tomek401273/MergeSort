package com.merge.sort;

import com.merge.sort.config.AppConfig;
import com.merge.sort.file.reader.FileReader;
import com.merge.sort.file.parser.FileParser;
import com.merge.sort.file.writer.FileWriter;
import com.merge.sort.service.MergeSort;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        FileReader fileReader= new FileReader();
        List<String> inputList= fileReader.getInputLines(AppConfig.getInputFilePath());
        FileParser fileParser= new FileParser();
        List<Integer[]> result = fileParser.parse(inputList);
        MergeSort mergeSort =new MergeSort();
        for (Integer[]line: result) {
//            int [] array= Arrays.stream(line).mapToInt(integer -> integer).toArray();
            mergeSort.sort(line);
//            System.out.println(line);
            Arrays.stream(line).map(x -> x + ", ").forEach(System.out::print);
            System.out.println();
        }
        FileWriter fileWriter= new FileWriter();
        fileWriter.write(result, AppConfig.getOutputPath());
    }
}
