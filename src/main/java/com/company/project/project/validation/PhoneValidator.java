package com.company.project.project.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, Object> {

    private String regex;
    private boolean checkBlank;

    @Override
    public void initialize(Phone matches) {
        this.regex = matches.regex();
        this.checkBlank = matches.checkBlank();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String fieldValue = String.valueOf(value);
        if (value == null || !StringUtils.hasText(fieldValue)) {
            if (checkBlank) {
                return false;
            }
            return true;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fieldValue);
        boolean match = matcher.find();
        if (!match) {
            String messageTemplate = context.getDefaultConstraintMessageTemplate();
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addConstraintViolation();
        }
        return match;
    }
}
