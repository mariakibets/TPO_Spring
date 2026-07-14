package pja.edu.pl.s30855.tpo_10.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;


public class PasswordValidator implements ConstraintValidator<Password, String> {

    private int minLength;
    private int minLowercase;
    private int minUppercase;
    private int minDigits;
    private int minSpecialChars;

    @Override
    public void initialize(Password constraintAnnotation) {
        this.minLength = constraintAnnotation.minLength();
        this.minLowercase = constraintAnnotation.minLowercase();
        this.minUppercase = constraintAnnotation.minUppercase();
        this.minDigits = constraintAnnotation.minDigits();
        this.minSpecialChars = constraintAnnotation.minSpecialChars();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {


        boolean valid = true;
        int lowercase = 0, uppercase = 0, digits = 0, special = 0;

        if (password == null || password.trim().isEmpty()) {
            return true;
        }

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) lowercase++;
            else if (Character.isUpperCase(c)) uppercase++;
            else if (Character.isDigit(c)) digits++;
            else if ("!@#$%^&*()_+-=[]{}|;:'\",.<>?/\\`~".indexOf(c) != -1) special++;
        }

        context.disableDefaultConstraintViolation();


        if (password.length() < minLength) {
            context.buildConstraintViolationWithTemplate("Password must be at least " + minLength + " characters long")
                    .addConstraintViolation();
            valid = false;
        }

        if (lowercase < minLowercase) {
            context.buildConstraintViolationWithTemplate("Password must have at least " + minLowercase + " lowercase letter(s)")
                    .addConstraintViolation();
            valid = false;
        }

        if (uppercase < minUppercase) {
            context.buildConstraintViolationWithTemplate("Password must have at least " + minUppercase + " uppercase letter(s)")
                    .addConstraintViolation();
            valid = false;
        }

        if (digits < minDigits) {
            context.buildConstraintViolationWithTemplate("Password must have at least " + minDigits + " digit(s)")
                    .addConstraintViolation();
            valid = false;
        }

        if (special < minSpecialChars) {
            context.buildConstraintViolationWithTemplate("Password must have at least " + minSpecialChars + " special character(s)")
                    .addConstraintViolation();
            valid = false;
        }

        return valid;
    }
}

