package com.merge.sort.file.parser;

import com.merge.sort.file.validator.LineValidator;
import com.merge.sort.file.validator.NumberValidator;
import com.merge.sort.model.Person;

import java.util.ArrayList;
import java.util.List;

public class FileParserPerson {
    private final NumberValidator numberValidator;
    private final LineValidator lineValidator;

    public FileParserPerson() {
        this.numberValidator = new NumberValidator();
        this.lineValidator= new LineValidator();
    }

    public List<Person> parse(List<String> lines) {

        List<Person> personList = new ArrayList<>();
        for (String line : lines) {
            // sprawdzenie czy linia jest poprawna
            // jeśli tak zostanie sparsowana
            // jesli nie zostanie pominięta
            if (lineValidator.isValid(line)) {
                String[] splits = line.split("\t");
                // parsowanie i dodanie do listy nowego obieku Person
                personList.add(parseLine(splits));
            }
        }
        return personList;
    }

    public Person parseLine(String[] splits) {
        // wyciągniecie splitów do zmiennych typu String
        String idString = splits[0].trim();
        String name = splits[1].trim();
        String surname= splits[2].trim();
        String ageString= splits[3].trim();
        // sprawdzenie czy id jest poprawna liczbą
        // jesli tak sparsowanie jej
        // jeśli nie zmienna ma wartość zero
        int id=0;
        if (numberValidator.isValid(idString)){
            id= Integer.parseInt(idString);
        }
        // sprawdzenie czy age jest poprawna liczbą
        // jesli tak sparsowanie jej
        // jeśli nie zmienna ma wartość zero
        int age=0;
        if (numberValidator.isValid(ageString)){
            age=Integer.parseInt(ageString);
        }
        // inicjaliacja obieku Person
        return new Person(id, name , surname, age);
    }
}
