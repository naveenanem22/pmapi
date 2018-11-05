package com.pmt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IndividualAddress {

	@JsonProperty(value = "id")
	private int id;

	@JsonProperty(value = "streetName")
	private String streetName;

	@JsonProperty(value = "buildingNumber")
	private String buildingNumber;

	@JsonProperty(value = "city")
	private String city;

	@JsonProperty(value = "state")
	private String state;

	@JsonProperty(value = "country")
	private String country;

	@JsonProperty(value = "postalCode")
	private int postalCode;

	@JsonProperty(value = "addressLine1")
	private String addressLine1;

	@JsonProperty(value = "addressLine2")
	private String addressLine2;

	@JsonProperty(value = "addressLine3")
	private String addressLine3;

	@JsonProperty(value = "addressType")
	private String addressType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	@Override
	public String toString() {
		return "IndividualAddress [id=" + id + ", streetName=" + streetName + ", buildingNumber=" + buildingNumber
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3=" + addressLine3
				+ ", addressType=" + addressType + ", getId()=" + getId() + ", getStreetName()=" + getStreetName()
				+ ", getBuildingNumber()=" + getBuildingNumber() + ", getCity()=" + getCity() + ", getState()="
				+ getState() + ", getCountry()=" + getCountry() + ", getPostalCode()=" + getPostalCode()
				+ ", getAddressLine1()=" + getAddressLine1() + ", getAddressLine2()=" + getAddressLine2()
				+ ", getAddressLine3()=" + getAddressLine3() + ", getAddressType()=" + getAddressType()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
