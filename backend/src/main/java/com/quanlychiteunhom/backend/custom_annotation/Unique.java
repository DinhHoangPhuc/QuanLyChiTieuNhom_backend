package com.quanlychiteunhom.backend.custom_annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = UniqueValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {
    String message() default "Value is not unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    FieldType fieldType(); // Enum to specify the field type like EMAIL, USERNAME, SDT.

    public enum FieldType {
        EMAIL, USERNAME, SDT
    }
}
