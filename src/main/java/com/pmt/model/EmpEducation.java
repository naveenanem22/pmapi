package com.pmt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pmt.validators.ScoreTypeConstraint;

@Entity
@Table(name="education")
public class EmpEducation {
	@Id
	@Column(name="edu_id")
	@JsonProperty(value="id")
	private String id;
	
	@Column(name="edu_empid")
	private String empId;
	
	@Column(name="edu_qualname")
	@JsonProperty(value="qualificationName")
	private String qualName;
	
	@Column(name="edu_specialization")
	@JsonProperty(value="spec")
	private String specialization;
	
	@Column(name="edu_startdate")
	@Temporal(TemporalType.DATE)
	@JsonProperty(value="qualStartDate")
	private Date qualStartDate;
	
	@Column(name="edu_enddate")
	@Temporal(TemporalType.DATE)
	@JsonProperty(value="qualEndDate")
	private Date qualEndDate;
	
	@Column(name="edu_score")	
	@JsonProperty(value="score")
	private float score;
	
	@Column(name="edu_scoretype")
	//@ScoreTypeConstraint(message = "scoreType")
	@JsonProperty(value="scoreType")
	private String scoreType;
	
	@Column(name="edu_institution")
	@JsonProperty(value="institution")
	private String institution;
	
	public EmpEducation(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getQualName() {
		return qualName;
	}

	public void setQualName(String qualName) {
		this.qualName = qualName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Date getQualStartDate() {
		return qualStartDate;
	}

	public void setQualStartDate(Date qualStartDate) {
		this.qualStartDate = qualStartDate;
	}

	public Date getQualEndDate() {
		return qualEndDate;
	}

	public void setQualEndDate(Date qualEndDate) {
		this.qualEndDate = qualEndDate;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getScoreType() {
		return scoreType;
	}

	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	
	
	
	
	
	
	
	

}
