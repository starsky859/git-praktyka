package pl.kurs.schooldiary.validations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PeselValidator1.class)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface Pesel1 {

    String message() default "{pesel.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
