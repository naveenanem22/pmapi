package com.pmt.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



import com.pmt.validators.impl.ScoreTypeValidator;

@Documented
@Constraint(validatedBy = ScoreTypeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ScoreTypeConstraint {
	String message() default "Invalid Score Type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
