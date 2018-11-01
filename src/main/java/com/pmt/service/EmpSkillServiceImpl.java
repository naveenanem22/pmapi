package com.pmt.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.EmpSkillDao;
import com.pmt.model.EmpSkill;

@Service(value = "empSkillServiceImpl")
public class EmpSkillServiceImpl implements EmpSkillService {

	@Autowired
	@Qualifier(value = "empSkillDaoImpl")
	private EmpSkillDao empSkillDao;

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public int addSkills(String employeeId, Set<EmpSkill> empSkills) {
		return empSkillDao.addSkills(employeeId, empSkills);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public int removeSkills(String employeeId, Set<String> skillIds) {
		return empSkillDao.removeSkills(employeeId, skillIds);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public List<EmpSkill> listSkillsById(String employeeId) {
		return empSkillDao.listSkillsById(employeeId);
	}

	@Override
	public void updateSkillsByEmployeeId(String employeeId, Set<EmpSkill> empSkills) {
		empSkillDao.updateSkillsByEmployeeId(employeeId, empSkills);

	}

}