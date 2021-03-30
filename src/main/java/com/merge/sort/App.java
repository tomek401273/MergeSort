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
        // wyświtl info o potrzebie wskazania gdzie jest plik wejściowy i wyściowy
        // oraz w jakim formacie powinien być plik
        // oraz w jakim formacie dane w tym pliku
        // oraz powdz że moze wpisać pole po jakim ma byc srotowne id, name etc. potem ma być spacja
        // oraz oraz jak ma być sortowane asc czy desc
        // bez tej poprawnie zainjcaizowanej tej zmiennej program nie powinien ruszyć
        // etc.
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

        SortPersonFieldComparatorMap sortPersonFieldComparatorMap = new SortPersonFieldComparatorMap();
        ComparatorPerson comparatorPerson = sortPersonFieldComparatorMap.getComparatorMap().get(sortOrder);
        if (comparatorPerson==null){
            System.out.println("Program can not continue without valid sort order field and (asc or desc)");
            System.exit(0);
        }

        FileReader fileReader = new FileReader();
        List<String> inputList = fileReader.getInputLines(appConfig.getInputFilePath());

        FileParserPerson fileParserPerson = new FileParserPerson();
        List<Person> people = fileParserPerson.parse(inputList);
        MergeSortPerson mergeSortPerson = new MergeSortPerson();
        mergeSortPerson.sort(people, comparatorPerson);

        FileWriterPerson fileWriterPerson = new FileWriterPerson();
        fileWriterPerson.write(people, appConfig.getOutputFilePath());

        // sprawdż wszszystko dokładnie komentarze są tam gdzie jest coś trugdniejszego
        // banalnych rzeczy nie komętaowałem
        // zrob testy
        // wyrzuć junit tesety (folder test/java) jeśli nie potrzebne  oraz
        // wtedy też to
        //     testImplementation 'org.junit.jupiter:junit-jupiter-api:5.6.0'
        //    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine'
        // w build gradle
        // aa i przed oddaniem spawdź czy jest ukryty folder .git jak jest to usuń to bo
        // tam moga być informacje kto to pisał
        // sprawdź jeszcze raz czy nie ma czegoś niepotrzebnego


    }
}
