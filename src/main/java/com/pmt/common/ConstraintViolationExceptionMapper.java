package com.pmt.common;

import java.util.List;
import java.util.stream.Collectors;

import static com.pmt.common.PMAPIConstants.REST_STATUS_FAILURE;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

import com.pmt.model.ValidationError;
import com.pmt.util.response.ResultWithData;

@Provider
public class ConstraintViolationExceptionMapper 
       implements ExceptionMapper<ConstraintViolationException> {
	
	@Autowired
	private ApplicationContext applicationContext;
	

    @Override
    public Response toResponse(ConstraintViolationException exception) {
    	ResultWithData result = new ResultWithData();

        List<ValidationError> errors = exception.getConstraintViolations().stream()
                .map(this::toValidationError)
                .collect(Collectors.toList());
        
        result.setData(errors);
        result.setStatus(REST_STATUS_FAILURE);
        GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};
        return Response.status(Status.BAD_REQUEST).entity(entity).build();
    }

    private ValidationError toValidationError(ConstraintViolation constraintViolation) {        
    	ValidationError error = (ValidationError) applicationContext.getBean("validationError");
        
        return setValues(error,constraintViolation.getPropertyPath().toString());
        //error.setPath(constraintViolation.getPropertyPath().toString());
        //error.setMessage(constraintViolation.getMessage());
        
    }
    private ValidationError setValues(ValidationError error, String propPath){
    	switch(propPath){
    	
    	case "gender":
    		error.setDeveloperMsg(PMAPIConstants.EMP_GENDER_DEV_MSG);
    		error.setErrCode(PMAPIConstants.EMP_GENDER_ERR_CODE);
    		error.setMoreInfo(PMAPIConstants.EMP_GENDER_MORE_INFO);
    		error.setPropertyPath("gender");
    		error.setUserMsg(PMAPIConstants.EMP_GENDER_USR_MSG);
    		break;
    	case "firstName":
    		error.setErrCode(PMAPIConstants.EMP_MARITAL_STATUS_ERR_CODE);
    		error.setDeveloperMsg(PMAPIConstants.EMP_MARITAL_STATUS_DEV_MSG);
    		error.setMoreInfo(PMAPIConstants.EMP_MARITAL_STATUS_MORE_INFO);
    		error.setPropertyPath("maritalstatus");
    		error.setUserMsg(PMAPIConstants.EMP_MARITAL_STATUS_USR_MSG);
    		break;   	
    	
    	default :
    		break;   	
    	}
    	return error;
    }
}