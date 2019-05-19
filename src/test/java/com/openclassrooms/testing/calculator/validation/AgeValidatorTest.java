package com.openclassrooms.testing.calculator.validation;

import org.junit.Test;

public class AgeValidatorTest {

    @Test(expected = InsaneAgeException.class)
    public void validate_shouldThrowAnException_forSomeoneOver200YearsOld() throws InsaneAgeException {
        AgeValidator ageValidator = new AgeValidator();
        ageValidator.validate(200);
    }

}