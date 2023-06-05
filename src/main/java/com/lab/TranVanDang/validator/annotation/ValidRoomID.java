package com.lab.TranVanDang.validator.annotation;

import com.lab.TranVanDang.validator.ValidRoomIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE,FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidRoomIdValidator.class)
@Documented
public @interface ValidRoomID {
    String message() default "Invalid room ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
