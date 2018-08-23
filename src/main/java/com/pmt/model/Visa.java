package com.pmt.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Visa {

	@JsonProperty(value = "id")
	private String id;

	@JsonProperty(value = "country")
	private String country;

	@JsonProperty(value = "visaType")
	private String visaType;

	@JsonProperty(value = "validTill")
	private Date validTill;

	@JsonProperty(value = "validFrom")
	private Date validFrom;

	public Visa() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getVisaType() {
		return visaType;
	}

	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}

	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

}
