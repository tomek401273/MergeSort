package com.merge.sort.file.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator implements Validator {
    //^\d+$ w tym regex
    // ^ -> oznacza początke Stringa
    // $ -> koniec Stringa
    // \d+ liczbę, kóra może miec wiele cyfr
    // są dwa  \\ bo jeden to jak zwany excape slash czy coś takiego
    // tak w ogóle to powinno się sprawdzić zy liczba jest w granicach Integera
    // ale już mi się nie chce
    // pozatym to proste możesz sam to zrobić :D
    // ale to bardzjiej w klasie FileParserPerson przed sprsowaniem id oraz age na int
    // albo zrobić kolejną klase z Validatorem która to będzie sprawdzać
    Pattern pattern = Pattern.compile("^\\d+$");

    @Override
    public boolean isValid(String text) {
        Matcher matcher = pattern.matcher(text);
        boolean isValid = matcher.find();
        return isValid;
    }
}
// to test regular expresions
// https://regex-testdrive.com/en/
// https://www.baeldung.com/java-check-string-number