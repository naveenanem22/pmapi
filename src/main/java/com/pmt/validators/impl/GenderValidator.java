package com.pmt.validators.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.pmt.common.ApplicationContextProvider;
import com.pmt.common.PMAPIConstants;
import com.pmt.util.propertyfilehandlers.AppErrorProperties;
import com.pmt.validators.GenderConstraint;


public class GenderValidator implements
  ConstraintValidator<GenderConstraint, String> {	
 
    @Override
    public void initialize(GenderConstraint gender) {
    }
 
    @Override
    public boolean isValid(String genderField,
      ConstraintValidatorContext cxt) {
    	ApplicationContextProvider appContext = new ApplicationContextProvider();
    	AppErrorProperties aep = appContext.getApplicationContext().getBean("appErrorProp", AppErrorProperties.class);
    	
    	if(genderField.equalsIgnoreCase(aep.getProperty("gender.values.male")) || 
    			genderField.equalsIgnoreCase(aep.getProperty("gender.values.female")))
        return true;
    	else 
    		return false;
    }

}
