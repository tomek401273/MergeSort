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
        String inputFileString= "input/test/input-person-list.txt"; // wczytaj tą zmienną ze skanera
        String outputFileString ="output/test/output-test1.txt"; // wczytaj tą zmienną ze skanera

        // inicjalizacja appConfig
        AppConfig appConfig= new AppConfig(inputFileString, outputFileString);
        // sprawdznie czy appConfig jest porpawnie zainicajliowany jeśli
        // jeśli nie powiadom usera oraz zamnknij program
        if (!appConfig.isAppConfigValid()){
            System.out.println("Program can not continue without valid file");
            System.exit(0);
        }
        FileReader fileReader = new FileReader();
        List<String> inputList = fileReader.getInputLines(appConfig.getInputFilePath());

        FileParserPerson fileParserPerson = new FileParserPerson();
        List<Person> people = fileParserPerson.parse(inputList);
        MergeSortPerson mergeSortPerson = new MergeSortPerson();

        SortPersonFieldComparatorMap sortPersonFieldComparatorMap = new SortPersonFieldComparatorMap();
        ComparatorPerson comparatorPerson = sortPersonFieldComparatorMap.getComparatorMap().get(sortOrder);

        mergeSortPerson.sort(people, comparatorPerson);


        FileWriterPerson fileWriterPerson = new FileWriterPerson();
        fileWriterPerson.write(people, appConfig.getOutputFilePath());
    }
}
