//package vn.daikajava.util;
//
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//
//import jakarta.validation.constraints.Pattern;
//
//import java.util.regex.Matcher;
//import java.util.regex.PatternSyntaxException;
package vn.daikajava.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;
public class EnumPatternValidator implements ConstraintValidator<EnumPattern, Enum<?>> {
    //định nghĩa partern ở đây
    private Pattern pattern;

    @Override
    public void initialize(EnumPattern enumPattern) {
        try {
            pattern = Pattern.compile(enumPattern.regexp()); //so sánh
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Given regex is invalid", e);
        }
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        Matcher m = pattern.matcher(value.name());
        return m.matches();
    }
}
