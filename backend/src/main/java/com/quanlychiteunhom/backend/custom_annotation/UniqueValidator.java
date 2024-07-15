package com.quanlychiteunhom.backend.custom_annotation;

import org.springframework.beans.factory.annotation.Autowired;

import com.quanlychiteunhom.backend.repositories.NguoiDungRepo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    private Unique.FieldType fieldType;

    @Autowired
    private NguoiDungRepo nguoiDungRepo;

    @Override
    public void initialize(Unique unique) {
        this.fieldType = unique.fieldType();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value == null) {
            throw new NullPointerException("Value is null");
        }

        switch (fieldType) {
            case EMAIL:
                return !nguoiDungRepo.existsByEmail(value.toString());
            case USERNAME:
                return !nguoiDungRepo.existsByUsername(value.toString());
            case SDT:
                return !nguoiDungRepo.existsBySdt(Integer.parseInt(value.toString()));
            default:
                throw new IllegalArgumentException("Unknown fieldType: " + fieldType + " for value: " + value);
        }
    }

}
