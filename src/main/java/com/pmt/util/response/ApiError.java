package com.pmt.util.response;

public class ApiError {
	private String message; //Contains Api error message
	private Object errors; //Contains individual field level error objects

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getErrors() {
		return errors;
	}

	public void setErrors(Object errors) {
		this.errors = errors;
	}

}
