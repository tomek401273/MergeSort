package com.merge.sort.file.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {
    @Test
    public void testValidInteger1(){
        NumberValidator numberValidator = new NumberValidator();
        boolean result =numberValidator.isValid("1");
        assertTrue(result);
    }

    // sprawdzić czy pattern zadziała dla innch liczb
    // sprwdzić skrajne przypadki
    @Test
    public void testNotValidDouble(){
        NumberValidator numberValidator = new NumberValidator();
        boolean result =numberValidator.isValid("1.1");
        assertFalse(result);
    }
    @Test
    public void testNotValidNumberWithString(){
        NumberValidator numberValidator = new NumberValidator();
        boolean result =numberValidator.isValid("1ala");
        assertFalse(result);
    }

}