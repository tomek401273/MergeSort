package com.merge.sort;

import com.merge.sort.config.AppConfig;
import com.merge.sort.file.parser.FileParserPerson;
import com.merge.sort.file.reader.FileReader;
import com.merge.sort.file.writer.FileWriterPerson;
import com.merge.sort.model.Person;
import com.merge.sort.service.ComparatorPerson;
import com.merge.sort.service.MergeSortPerson;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppPerson {
    public static void main(String[] args) {
        AppConfig.setInputFilePath("input/test/input-person-list.txt");
        AppConfig.setOutputFilePath("output/test/output-test1.txt");

        FileReader fileReader = new FileReader();
        List<String> inputList = fileReader.getInputLines(AppConfig.getInputFilePath());
        inputList.forEach(s -> System.out.println(s));
        FileParserPerson fileParserPerson= new FileParserPerson();
        Person[] people= fileParserPerson.parse(inputList);
        MergeSortPerson mergeSortPerson = new MergeSortPerson();
        Map<String, ComparatorPerson> map =new HashMap<>();
        map.put("age asc", (person1, person2) -> person1.getAge().compareTo(person2.getAge())<0);
        map.put("name asc", (person1, person2) -> person1.getName().compareTo(person2.getName()) < 0);
        ComparatorPerson comparatorPerson = map.get("age asc") ;
//        ComparatorPerson comparatorPerson = map.get("name asc") ;

        mergeSortPerson.sort(people, comparatorPerson);
        Arrays.stream(people).forEach(person -> System.out.println(person));

        FileWriterPerson fileWriterPerson =new FileWriterPerson();
        fileWriterPerson.write(Arrays.asList(people), AppConfig.getOutputPath());

    }
}
