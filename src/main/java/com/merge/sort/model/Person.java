package com.merge.sort.model;

import lombok.*;

@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;

    @Override
    public String toString() {
        return
                id + " \t" +
                        name + " \t" +
                        surname + " \t" +
                        +age + " \t";
    }
}
