package com.pmt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpAddress {

	@JsonProperty(value = "city")
	private String city;

	@JsonProperty(value = "state")
	private String state;

	@JsonProperty(value = "country")
	private String country;

	@JsonProperty(value = "pincode")
	private int pincode;

	@JsonProperty(value = "street")
	private String street;

	@JsonProperty(value = "addressLine1")
	private String addressLine1;

	@JsonProperty(value = "addressLine2")
	private String addressLine2;

	@JsonProperty(value = "addressType")
	private String addressType;

	@JsonProperty(value = "oldAddressType")
	private String oldAddressType;

	public String getOldAddressType() {
		return oldAddressType;
	}

	public void setOldAddressType(String oldAddressType) {
		this.oldAddressType = oldAddressType;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

}
