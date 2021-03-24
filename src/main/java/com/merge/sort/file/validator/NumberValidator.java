package com.merge.sort.file.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator {
    Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isValid(String text) {
        Matcher matcher = pattern.matcher(text);
        boolean isValid = matcher.find();
        return isValid;
    }
}
// to test regular expresions
// https://regex-testdrive.com/en/
// https://www.baeldung.com/java-check-string-number