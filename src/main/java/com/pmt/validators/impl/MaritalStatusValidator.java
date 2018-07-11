package com.pmt.validators.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import com.pmt.common.ApplicationContextProvider;
import com.pmt.util.propertyfilehandlers.AppErrorProperties;
import com.pmt.validators.MaritalStatusConstraint;


public class MaritalStatusValidator implements
  ConstraintValidator<MaritalStatusConstraint, String> {	
 
    @Override
    public void initialize(MaritalStatusConstraint gender) {
    }
 
    @Override
    public boolean isValid(String genderField,
      ConstraintValidatorContext cxt) {
    	ApplicationContextProvider appContext = new ApplicationContextProvider();
    	AppErrorProperties aep = appContext.getApplicationContext().getBean("appErrorProp", AppErrorProperties.class);
    	
    	if(genderField.equalsIgnoreCase(aep.getProperty("maritalStatus.values.married")) || 
    			genderField.equalsIgnoreCase(aep.getProperty("maritalStatus.values.divorced")) ||
    			genderField.equalsIgnoreCase(aep.getProperty("maritalStatus.values.single")))
        return true;
    	else 
    		return false;
    }

}
