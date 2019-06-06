package com.pmt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactInfo {

	@JsonProperty(value = "id")
	private int id;

	@JsonProperty(value = "homePhone")
	private String homePhone;

	@JsonProperty(value = "homePhoneCountryCode")
	private String homePhoneCountryCode;

	@JsonProperty(value = "officePhone")
	private String officePhone;

	@JsonProperty(value = "officePhoneCountryCode")
	private String officePhoneCountryCode;

	@JsonProperty(value = "primaryMobile")
	private String primaryMobile;

	@JsonProperty(value = "secondaryMobile")
	private String secondaryMobile;

	@JsonProperty(value = "primaryMobileCountryCode")
	private String primaryMobileCountryCode;

	@JsonProperty(value = "secondaryMobileCountryCode")
	private String secondaryMobileCountryCode;

	public ContactInfo() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getHomePhoneCountryCode() {
		return homePhoneCountryCode;
	}

	public void setHomePhoneCountryCode(String homePhoneCountryCode) {
		this.homePhoneCountryCode = homePhoneCountryCode;
	}

	public String getPrimaryMobile() {
		return primaryMobile;
	}

	public void setPrimaryMobile(String primaryMobile) {
		this.primaryMobile = primaryMobile;
	}

	public String getSecondaryMobile() {
		return secondaryMobile;
	}

	public void setSecondaryMobile(String secondaryMobile) {
		this.secondaryMobile = secondaryMobile;
	}

	public String getPrimaryMobileCountryCode() {
		return primaryMobileCountryCode;
	}

	public void setPrimaryMobileCountryCode(String primaryMobileCountryCode) {
		this.primaryMobileCountryCode = primaryMobileCountryCode;
	}

	public String getSecondaryMobileCountryCode() {
		return secondaryMobileCountryCode;
	}

	public void setSecondaryMobileCountryCode(String secondaryMobileCountryCode) {
		this.secondaryMobileCountryCode = secondaryMobileCountryCode;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getOfficePhoneCountryCode() {
		return officePhoneCountryCode;
	}

	public void setOfficePhoneCountryCode(String officePhoneCountryCode) {
		this.officePhoneCountryCode = officePhoneCountryCode;
	}

	@Override
	public String toString() {
		return "ContactInfo [id=" + id + ", homePhone=" + homePhone + ", homePhoneCountryCode=" + homePhoneCountryCode
				+ ", officePhone=" + officePhone + ", officePhoneCountryCode=" + officePhoneCountryCode
				+ ", primaryMobile=" + primaryMobile + ", secondaryMobile=" + secondaryMobile
				+ ", primaryMobileCountryCode=" + primaryMobileCountryCode + ", secondaryMobileCountryCode="
				+ secondaryMobileCountryCode + "]";
	}

}
