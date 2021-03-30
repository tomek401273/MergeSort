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
        List<Person> personList = new ArrayList<>();
        personList.add( new Person(1, "tom4", "thomson", 25));
        personList.add(new Person(2, "tom6", "thomson", 26));
        personList.add(new Person(3, "tom2", "thomson", 27));

        MergeSortPerson mergeSortPerson = new MergeSortPerson();
        ComparatorPerson comparatorPerson = (person1, person2) -> person1.getName().compareTo(person2.getName()) < 0;
//        ComparatorPerson comparatorPerson = (person1, person2) -> person1.getAge().compareTo(person2.getAge())>0;
        mergeSortPerson.sort(personList, comparatorPerson);

        Assertions.assertEquals("tom2", personList.get(0).getName());
        Assertions.assertEquals("tom4", personList.get(1).getName());
        Assertions.assertEquals("tom6", personList.get(2).getName());
    }

    @Test
    public void sortPersonByAge() {
        List<Person> personList = new ArrayList<>();
        personList.add( new Person(1, "tom4", "thomson", 25));
        personList.add(new Person(2, "tom6", "thomson", 26));
        personList.add(new Person(3, "tom2", "thomson", 27));

        MergeSortPerson mergeSortPerson = new MergeSortPerson();
        ComparatorPerson comparatorPerson = (person1, person2) -> person1.getAge().compareTo(person2.getAge())>0;
        mergeSortPerson.sort(personList, comparatorPerson);

        Assertions.assertEquals(27, personList.get(0).getAge());
        Assertions.assertEquals(26, personList.get(1).getAge());
        Assertions.assertEquals(25, personList.get(2).getAge());
    }
}
