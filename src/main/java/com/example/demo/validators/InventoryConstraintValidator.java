package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InventoryConstraintValidator implements ConstraintValidator<ValidInventory, Part> {



    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;
        if (part.getInv() >= part.getMinInv() && part.getInv() <= part.getMaxInv()) {
            result = true;
        }
        else if (part.getInv() < part.getMinInv()) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("inventory cannot be below minimum value").addConstraintViolation();
        }
        else {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("inventory cannot be above maximum value").addConstraintViolation();
        }
        return result;
    }


}
