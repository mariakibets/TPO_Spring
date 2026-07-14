package pja.edu.pl.s30855.tpo_10.Annotation;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "Password is too weak";

    int minLength() default 10;
    int minLowercase() default 1;
    int minUppercase() default 2;
    int minDigits() default 3;
    int minSpecialChars() default 4;

    Class[] groups() default {};
    Class[] payload() default {};
}
