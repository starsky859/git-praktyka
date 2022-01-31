package pl.kurs.schooldiary.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeselValidator implements ConstraintValidator<Pesel, String> {

    @Override
    public void initialize(Pesel constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return false;
        if (s.length() != 11) return false;
        try {
            Long.parseLong(s);
        } catch (RuntimeException ex) {
            return false;
        }
        return true;
    }
}
