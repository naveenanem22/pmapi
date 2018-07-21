package com.pmt.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;




import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pmt.common.PMAPIConstants;
import com.pmt.validators.ContactNumberConstraint;
import com.pmt.validators.GenderConstraint;
import com.pmt.validators.MaritalStatusConstraint;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="emp_id")
	private String id;
	
	@Column(name="emp_firstname")
	@Size(min = 1, max = 25, message = "firstName")	
	private String firstName;
	
	@Column(name="emp_lastname")
	private String lastName;
	
	@Column(name="emp_gender")
	@GenderConstraint(message = "gender")
	private String gender;
	
	@Column(name="emp_maritalstatus")
	@MaritalStatusConstraint(message = "maritalStatus")
	private String maritalStatus;
	
	@Temporal(TemporalType.DATE)//This is mapped to emp_dob(of DATE datatype) of employee table in mysql 
	@Column(name="emp_dob")
	private Date dob;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	@Column(name="emp_createddate", updatable = false)// updatable=true is necessary even though @CreationTimestamp is present 
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="emp_updateddate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date updatedDate;
	
	
	public Employee(){
		
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	

}
