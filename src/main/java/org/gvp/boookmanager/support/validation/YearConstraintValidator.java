package org.gvp.boookmanager.support.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class YearConstraintValidator implements ConstraintValidator<Year, Integer> {

    @Override
    public void initialize(Year year) {

    }

    @Override
    public boolean isValid(Integer printYear, ConstraintValidatorContext constraintValidatorContext) {
        if(printYear == null) return false;
        return printYear > 1 && printYear <= LocalDate.now().getYear();
    }
}
