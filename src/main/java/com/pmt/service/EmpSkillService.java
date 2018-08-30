package com.pmt.service;

import java.util.List;
import java.util.Set;

import com.pmt.model.EmpSkill;

public interface EmpSkillService {
	int addSkills(String employeeId, Set<EmpSkill> empSkills);
	int removeSkills(String employeeId, Set<String> skillIds);
	List<EmpSkill> listSkillsById(String employeeId);
	void updateSkillsByEmployeeId(String employeeId, Set<EmpSkill> empSkills);

}
