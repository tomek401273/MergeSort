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

    // to jest dość skoplikowane bo nie znasz functionalInterface oraz lambda expresions
    // w skócie mamy mapę w której są Stringi oraz obiekty typu ComparatorPerson
    // na podstawie String kóry przekaże user np. id asc jest zracany odpowiedni ComparatorPerson
    // ComparatorPerson to jest interface który ma jedną metodę  boolean compare(Person person1, Person person2);
    // przyjmuje ona dwa objekty typu Person
    // zraca boolean z ich porównania
    // implementacje tej metody to wartości w mapie czyli to: (person1, person2) -> person1.getAge().compareTo(person2.getAge()) < 0)
    // mamy person1 i person2 bierzemy z pierwszej age wywołujemy metodę comareTo mają ją Stringi oraz Integery
    // i przekazujemy do comapareTo age z person2
    // można by tą mapę załatwić ifami ale tak jest o wiele ładniej
}
