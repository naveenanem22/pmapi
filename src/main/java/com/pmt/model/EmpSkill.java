package com.pmt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpSkill {

	@JsonProperty(value = "id")
	int id;

	@JsonProperty(value = "skill")
	private Skill skill;

	@JsonProperty(value = "experienceInMonths")
	private int experienceInMonths;

	public EmpSkill() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public int getExperienceInMonths() {
		return experienceInMonths;
	}

	public void setExperienceInMonths(int experienceInMonths) {
		this.experienceInMonths = experienceInMonths;
	}

}
