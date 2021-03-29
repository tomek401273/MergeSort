package com.merge.sort;

import com.merge.sort.model.Person;
import com.merge.sort.service.ComparatorPerson;
import com.merge.sort.service.MergeSortPerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTest {
    @Test
    public void sortPersonByName() {
        Person[] personList = new Person[3];
        personList[0] = new Person(1, "tom4", "thomson", 25);
        personList[1] = new Person(2, "tom6", "thomson", 26);
        personList[2] = new Person(3, "tom2", "thomson", 27);
        Arrays.stream(personList).forEach(person -> System.out.println(person));
        System.out.println();
        MergeSortPerson mergeSortPerson = new MergeSortPerson();
        ComparatorPerson comparatorPerson = (person1, person2) -> person1.getName().compareTo(person2.getName()) < 0;
//        ComparatorPerson comparatorPerson = (person1, person2) -> person1.getAge().compareTo(person2.getAge())>0;
        mergeSortPerson.sort(personList, comparatorPerson);
        Arrays.stream(personList).forEach(person -> System.out.println(person));
        Assertions.assertEquals("tom2", personList[0].getName());
        Assertions.assertEquals("tom4", personList[1].getName());
        Assertions.assertEquals("tom6", personList[2].getName());
    }

    @Test
    public void sortPersonByAge() {
        Person[] personList = new Person[3];
        personList[0] = new Person(1, "tom4", "thomson", 25);
        personList[1] = new Person(2, "tom6", "thomson", 26);
        personList[2] = new Person(3, "tom2", "thomson", 27);

        MergeSortPerson mergeSortPerson = new MergeSortPerson();
        ComparatorPerson comparatorPerson = (person1, person2) -> person1.getAge().compareTo(person2.getAge())>0;
        mergeSortPerson.sort(personList, comparatorPerson);

        Assertions.assertEquals(27, personList[0].getAge());
        Assertions.assertEquals(26, personList[1].getAge());
        Assertions.assertEquals(25, personList[2].getAge());
    }
}
