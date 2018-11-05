package com.pmt.service;

import java.util.List;
import java.util.Set;

import com.pmt.model.EmpSkill;

public interface EmpSkillService {
	int addSkills(int employeeId, Set<EmpSkill> empSkills);
	int removeSkills(int employeeId, Set<Integer> skillIds);
	List<EmpSkill> listSkillsById(int employeeId);
	void updateSkillsByEmployeeId(int employeeId, Set<EmpSkill> empSkills);

}
