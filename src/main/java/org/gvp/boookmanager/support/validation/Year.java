package org.gvp.boookmanager.support.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = YearConstraintValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Year {

    String message() default "Can be greater 1 and less or equal current year";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}