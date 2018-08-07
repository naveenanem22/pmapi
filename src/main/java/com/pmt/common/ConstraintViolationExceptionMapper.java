package com.pmt.common;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.pmt.common.PMAPIConstants.REST_STATUS_FAILURE;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

import com.pmt.model.ValidationError;
import com.pmt.util.propertyfilehandlers.AppErrorProperties;
import com.pmt.util.response.ApiError;
import com.pmt.util.response.ResultWithData;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		ApiError apiError = new ApiError();

		List<ValidationError> errors = exception.getConstraintViolations().stream().map(this::toValidationError)
				.collect(Collectors.toList());

		apiError.setErrors(errors);
		apiError.setMessage(REST_STATUS_FAILURE);
		GenericEntity<ApiError> entity = new GenericEntity<ApiError>(apiError) {
		};
		return Response.status(Status.BAD_REQUEST).entity(entity).build();
	}

	private ValidationError toValidationError(ConstraintViolation constraintViolation) {
		ValidationError error = (ValidationError) applicationContext.getBean("validationError");

		return setValues(error, constraintViolation.getMessage(), constraintViolation.getInvalidValue().toString(),
				StreamSupport.stream(constraintViolation.getPropertyPath().spliterator(), false).map(Path.Node::getName)
						.reduce((first, second) -> second)
						.orElseGet(() -> constraintViolation.getPropertyPath().toString()));

	}

	private ValidationError setValues(ValidationError error, String messageBasedKey, String value,
			String propertyPath) {
		AppErrorProperties aep = (AppErrorProperties) applicationContext.getBean("appErrorProp");
		error.setDeveloperMsg(aep.getProperty(messageBasedKey + ".dev.msg"));
		error.setErrCode(aep.getProperty(messageBasedKey + ".err.code"));
		error.setMoreInfo(aep.getProperty(messageBasedKey + ".more.info"));
		error.setUserMsg(aep.getProperty(messageBasedKey + ".user.msg"));
		error.setValue(value);
		error.setPropertyPath(propertyPath);

		return error;
	}
}