package com.pmt.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pc.model.Badge;
import com.pmt.common.JsonDateDeserializer;
import com.pmt.common.JsonDateSerializer;
import com.pmt.validators.GenderConstraint;
import com.pmt.validators.MaritalStatusConstraint;

public class Employee {

	@JsonProperty(value = "id")
	private int id;

	@Size(min = 1, max = 25, message = "firstName")
	@JsonProperty(value = "firstName")
	private String firstName;

	@JsonProperty(value = "lastName")
	private String lastName;

	@JsonProperty(value = "gender")
	@GenderConstraint(message = "gender")
	private String gender;

	@JsonProperty(value = "maritalStatus")
	@MaritalStatusConstraint(message = "maritalStatus")
	private String maritalStatus;

	@JsonProperty(value = "dob")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dob;

	@JsonProperty(value = "createdDate")
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private LocalDateTime createdDate;

	@JsonProperty(value = "updatedDate")
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private LocalDateTime updatedDate;

	@JsonProperty(value = "individualAddress")
	private IndividualAddress individualAddress;

	@JsonProperty(value = "contactInfo")
	private ContactInfo contactInfo;

	@JsonProperty(value = "aboutMe")
	private String aboutMe;

	@JsonProperty(value = "designation")
	private String designation;

	@JsonProperty(value = "badges")
	private List<Badge> badges;

	@JsonProperty(value = "credits")
	private int credits;

	public Employee() {

	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public List<Badge> getBadges() {
		return badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public IndividualAddress getIndividualAddress() {
		return individualAddress;
	}

	public void setIndividualAddress(IndividualAddress individualAddress) {
		this.individualAddress = individualAddress;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", maritalStatus=" + maritalStatus + ", dob=" + dob + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", individualAddress=" + individualAddress + ", contactInfo="
				+ contactInfo + ", aboutMe=" + aboutMe + ", designation=" + designation + ", badges=" + badges
				+ ", credits=" + credits + "]";
	}

}
