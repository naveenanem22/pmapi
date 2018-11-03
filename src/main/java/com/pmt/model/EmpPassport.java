package com.pmt.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpPassport {

	@JsonProperty(value = "id")
	private int id;

	@JsonProperty(value = "passportNumber")
	private String passportNumber;

	@JsonProperty(value = "dateOfIssue")
	private Date dateOfIssue;

	@JsonProperty(value = "dateOfExpiry")
	private Date dateOfExpiry;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

}
