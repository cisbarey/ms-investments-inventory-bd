package mx.com.actinver.ms.helpers.util;

import javax.validation.ConstraintValidatorContext;

public class CustomValidationUtil {

    public static void setNewMessage(ConstraintValidatorContext context, String message){
        context.disableDefaultConstraintViolation();
        context
                .buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
    }
}
