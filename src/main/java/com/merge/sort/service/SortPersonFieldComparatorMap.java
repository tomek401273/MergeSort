package com.merge.sort.service;

import java.util.HashMap;
import java.util.Map;

public class SortPersonFieldComparatorMap {
    public Map<String, ComparatorPerson> getComparatorMap() {
        Map<String, ComparatorPerson> map = new HashMap<>();
        map.put("id asc", (person1, person2) -> person1.getAge().compareTo(person2.getAge()) < 0);
        map.put("age asc", (person1, person2) -> person1.getAge().compareTo(person2.getAge()) < 0);
        map.put("name asc", (person1, person2) -> person1.getName().compareTo(person2.getName()) < 0);
        map.put("surname asc", (person1, person2) -> person1.getSurname().compareTo(person2.getSurname()) < 0);

        map.put("id desc", (person1, person2) -> person1.getAge().compareTo(person2.getAge()) > 0);
        map.put("age desc", (person1, person2) -> person1.getAge().compareTo(person2.getAge()) > 0);
        map.put("name desc", (person1, person2) -> person1.getName().compareTo(person2.getName()) > 0);
        map.put("surname desc", (person1, person2) -> person1.getSurname().compareTo(person2.getSurname()) > 0);
        return map;
    }
}
