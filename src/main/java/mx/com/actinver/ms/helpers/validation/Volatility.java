package mx.com.actinver.ms.helpers.validation;

import mx.com.actinver.ms.helpers.validation.impl.VolatilityValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = VolatilityValidator.class)
@Target( { ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Volatility {
    public String message() default "A Volatility value is invalid";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
