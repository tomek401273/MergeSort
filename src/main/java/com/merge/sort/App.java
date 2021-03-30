package com.merge.sort;

import com.merge.sort.config.AppConfig;
import com.merge.sort.file.parser.FileParserPerson;
import com.merge.sort.file.reader.FileReader;
import com.merge.sort.file.writer.FileWriterPerson;
import com.merge.sort.model.Person;
import com.merge.sort.service.ComparatorPerson;
import com.merge.sort.service.MergeSortPerson;
import com.merge.sort.service.SortPersonFieldComparatorMap;

import java.util.List;

public class App {
    public static void main(String[] args) {
        String sortOrder = "age asc"; // wczytaj tą zmienną ze skanera
        AppConfig.setInputFilePath("input/test/input-person-list.txt");
        AppConfig.setOutputFilePath("output/test/output-test1.txt");

        FileReader fileReader = new FileReader();
        List<String> inputList = fileReader.getInputLines(AppConfig.getInputFilePath());

        FileParserPerson fileParserPerson = new FileParserPerson();
        List<Person> people = fileParserPerson.parse(inputList);
        MergeSortPerson mergeSortPerson = new MergeSortPerson();

        SortPersonFieldComparatorMap sortPersonFieldComparatorMap = new SortPersonFieldComparatorMap();
        ComparatorPerson comparatorPerson = sortPersonFieldComparatorMap.getComparatorMap().get(sortOrder);

        mergeSortPerson.sort(people, comparatorPerson);


        FileWriterPerson fileWriterPerson = new FileWriterPerson();
        fileWriterPerson.write(people, AppConfig.getOutputPath());
    }
}
