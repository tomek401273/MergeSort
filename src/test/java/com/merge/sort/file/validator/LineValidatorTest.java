package com.merge.sort.file.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineValidatorTest {
    @Test
    public void lineValidTest(){
        String line="1 \tJan\t Kowalski\t 40";
        LineValidator lineValidator= new LineValidator();
        boolean isValid = lineValidator.isValid(line);
        assertTrue(isValid);
    }

}