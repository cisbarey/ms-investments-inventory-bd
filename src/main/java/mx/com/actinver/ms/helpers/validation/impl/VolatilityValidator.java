package mx.com.actinver.ms.helpers.validation.impl;

import mx.com.actinver.ms.enums.VolatilityLevel;
import mx.com.actinver.ms.helpers.util.CustomValidationUtil;
import mx.com.actinver.ms.helpers.validation.Volatility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VolatilityValidator implements ConstraintValidator<Volatility, List<String>> {


    @Override
    public boolean isValid(List<String> values, ConstraintValidatorContext constraintValidatorContext) {
        if (values == null) {
            return true;
        }

        Boolean isValidLength = hasValidLength(values.size(), constraintValidatorContext);
        if (!isValidLength) {
            return false;
        }

        Boolean isValidList = hasNotRepeatedValues(values, constraintValidatorContext);
        if(!isValidList){
            return false;
        }

        Boolean isValidValues = hasValidValues(values, constraintValidatorContext);
        if(!isValidValues){
            return false;
        }

        return true;
    }

    private Boolean hasValidLength(Integer valuesLength, ConstraintValidatorContext context) {
        Integer maxLength = VolatilityLevel.values().length;
        Boolean isValid = maxLength >= valuesLength;
        if(!isValid){
            CustomValidationUtil.setNewMessage(context,
                    "Volatility field has more items than needed. Max items: " + maxLength);
        }
        return isValid;
    }

    private Boolean hasNotRepeatedValues(List<String> values, ConstraintValidatorContext context) {
        Boolean isValid = false;
        for (String value : values) {
            isValid = Collections.frequency(values, value) == 1;
            if (!isValid) {
                CustomValidationUtil.setNewMessage(context,
                        "Volatility field has a repeated value: " + value);
                break;
            }
        }
        return isValid;
    }

    private Boolean hasValidValues(List<String> values, ConstraintValidatorContext context) {
        Boolean isValid = false;
        for (String value : values) {
            isValid = Arrays.stream(VolatilityLevel.values()).anyMatch(enumValue -> enumValue.getLevel().equalsIgnoreCase(value));
            if (!isValid) {
                CustomValidationUtil.setNewMessage(context,
                        "Volatility field has a invalid value: " + value);
                break;
            }
        }
        return isValid;
    }
}
