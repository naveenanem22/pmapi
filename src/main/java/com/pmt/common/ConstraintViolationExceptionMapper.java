package com.pmt.common;

import java.util.List;
import java.util.stream.Collectors;

import static com.pmt.common.PMAPIConstants.REST_STATUS_FAILURE;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.pmt.model.ValidationError;
import com.pmt.util.response.ResultWithData;

@Provider
public class ConstraintViolationExceptionMapper 
       implements ExceptionMapper<ConstraintViolationException> {

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
        ValidationError error = new ValidationError();
        error.setPath(constraintViolation.getPropertyPath().toString());
        error.setMessage(constraintViolation.getMessage());
        return error;
    }
}