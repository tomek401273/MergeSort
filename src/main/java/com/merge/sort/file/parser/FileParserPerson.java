package com.merge.sort.file.parser;

import com.merge.sort.file.validator.NumberValidator;
import com.merge.sort.model.Person;

import java.util.ArrayList;
import java.util.List;

public class FileParserPerson {
    public List<Person> parse(List<String> lines) {
        NumberValidator numberValidator = new NumberValidator();
        List<Person> personList= new ArrayList<>();
        for (String line : lines) {
            String[] splits = line.split("\t");
            System.out.println(line);
            personList.add(parseLine(splits, numberValidator));
        }
       return personList;
    }

    public Person parseLine(String[] splits, NumberValidator numberValidator) {
        return new Person(Integer.valueOf(splits[0].trim()), splits[1].trim(), splits[2].trim(), Integer.valueOf(splits[3].trim()));
    }
}
