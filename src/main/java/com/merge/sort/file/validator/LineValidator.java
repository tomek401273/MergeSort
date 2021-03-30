package com.merge.sort.file.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineValidator implements Validator{
    String regex= "\t";
    Pattern pattern = Pattern.compile(regex);
    // sprawdzenie czy lnia zawiera 3 tab
    @Override
    public boolean isValid(String text) {
        Matcher matcher = pattern.matcher(text);
        long count =matcher.results().count();
        return count==3;
    }
}
