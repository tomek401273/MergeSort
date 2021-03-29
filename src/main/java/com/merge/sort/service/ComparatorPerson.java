package com.merge.sort.service;

import com.merge.sort.model.Person;

public interface ComparatorPerson {
    boolean compare(Person person1, Person person2);
}
