package com.pmt.validators.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import com.pmt.common.ApplicationContextProvider;
import com.pmt.util.propertyfilehandlers.AppErrorProperties;
import com.pmt.validators.ScoreTypeConstraint;


public class ScoreTypeValidator implements
  ConstraintValidator<ScoreTypeConstraint, String> {	
 
    @Override
    public void initialize(ScoreTypeConstraint scroreType) {
    }
 
    @Override
    public boolean isValid(String scoreTypeField,
      ConstraintValidatorContext cxt) {
    	ApplicationContextProvider appContext = new ApplicationContextProvider();
    	AppErrorProperties aep = appContext.getApplicationContext().getBean("appErrorProp", AppErrorProperties.class);
    	
    	if(scoreTypeField.equalsIgnoreCase(aep.getProperty("scoreType.values.gpa")) || 
    			scoreTypeField.equalsIgnoreCase(aep.getProperty("scoreType.values.percentage")))
        return true;
    	else 
    		return false;
    }

}
