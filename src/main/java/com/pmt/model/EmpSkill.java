package com.pmt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpSkill {

	@JsonProperty(value = "skillId")
	private String skillId;

	private String skillName;

	@JsonProperty(value = "experienceInMonths")
	private int experienceInMonths;

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	public int getExperienceInMonths() {
		return experienceInMonths;
	}

	public void setExperienceInMonths(int experienceInMonths) {
		this.experienceInMonths = experienceInMonths;
	}

}
