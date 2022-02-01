package pl.kurs.schooldiary.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeselValidator1 implements ConstraintValidator<Pesel1, String> {


    @Override
    public void initialize(Pesel1 constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {


        if (s == null) return false;
        if (s.length() != 11) return false;
        try {
            Long.parseLong(s);
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }
}
