package com.pmt.validators.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.pmt.common.PMAPIConstants;
import com.pmt.validators.GenderConstraint;

public class GenderValidator implements
  ConstraintValidator<GenderConstraint, String> {
 
    @Override
    public void initialize(GenderConstraint gender) {
    }
 
    @Override
    public boolean isValid(String genderField,
      ConstraintValidatorContext cxt) {
    	if(genderField.equalsIgnoreCase(PMAPIConstants.EMP_GENDER_MALE) || 
    			genderField.equalsIgnoreCase(PMAPIConstants.EMP_GENDER_FEMALE))
        return true;
    	else 
    		return false;
    }

}
