package com.pmt.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpPrevEmployment {

	@JsonProperty(value = "companyName")
	private String companyName;

	@JsonProperty(value = "totalExperienceInMonths")
	private int totalExperienceInMonths;

	@JsonProperty(value = "relevantExperienceInMonths")
	private int relevantExperienceInMonths;

	@JsonProperty(value = "startDate")
	private Date startDate;

	@JsonProperty(value = "endDate")
	private Date endDate;

	@JsonProperty(value = "designation")
	private String designation;

	@JsonProperty(value = "remuneration")
	private BigDecimal remuneration;

	@JsonProperty(value = "natureOfEmployment")
	private String natureOfEmployment;

	@JsonProperty(value = "supervisorName")
	private String supervisorName;

	@JsonProperty(value = "supervisorDesignation")
	private String supervisorDesignation;

	@JsonProperty(value = "reasonForLeaving")
	private String reasonForLeaving;

	@JsonProperty(value = "supervisorEmailId")
	private String supervisorEmailId;

	@JsonProperty(value = "employeeCode")
	private String employeeCode;

	@JsonProperty(value = "oldStartDate")
	private Date oldStartDate;

	public Date getOldStartDate() {
		return oldStartDate;
	}

	public void setOldStartDate(Date oldStartDate) {
		this.oldStartDate = oldStartDate;
	}

	public BigDecimal getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(BigDecimal remuneration) {
		this.remuneration = remuneration;
	}

	public String getNatureOfEmployment() {
		return natureOfEmployment;
	}

	public void setNatureOfEmployment(String natureOfEmployment) {
		this.natureOfEmployment = natureOfEmployment;
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public String getSupervisorDesignation() {
		return supervisorDesignation;
	}

	public void setSupervisorDesignation(String supervisorDesignation) {
		this.supervisorDesignation = supervisorDesignation;
	}

	public String getReasonForLeaving() {
		return reasonForLeaving;
	}

	public void setReasonForLeaving(String reasonForLeaving) {
		this.reasonForLeaving = reasonForLeaving;
	}

	public String getSupervisorEmailId() {
		return supervisorEmailId;
	}

	public void setSupervisorEmailId(String supervisorEmailId) {
		this.supervisorEmailId = supervisorEmailId;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getTotalExperienceInMonths() {
		return totalExperienceInMonths;
	}

	public void setTotalExperienceInMonths(int totalExperienceInMonths) {
		this.totalExperienceInMonths = totalExperienceInMonths;
	}

	public int getRelevantExperienceInMonths() {
		return relevantExperienceInMonths;
	}

	public void setRelevantExperienceInMonths(int relevantExperienceInMonths) {
		this.relevantExperienceInMonths = relevantExperienceInMonths;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
