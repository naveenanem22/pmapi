package com.pmt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="visa")
public class Visa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vsa_id")
	private int id;
	
	@Column(name="vsa_country")
	private String country;
	
	@Column(name="vsa_type")
	private String visaType;
	
	@Column(name="vsa_validtill")
	private Date validTill;
	

	
	public Visa(){
		
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
