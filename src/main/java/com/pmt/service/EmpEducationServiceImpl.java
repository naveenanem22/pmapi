package com.pmt.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pmt.dao.EmpEducationDao;
import com.pmt.model.EmpEducation;

@Service(value = "empEducationServiceImpl")
public class EmpEducationServiceImpl implements EmpEducationService {

	@Autowired
	@Qualifier(value = "empEducationDaoImpl")
	private EmpEducationDao empEducationDao;

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public void addEmpEducation(EmpEducation empEducation, String empId) {
		empEducation.setEmpId(empId);
		this.empEducationDao.addEmpEducation(empEducation);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public void updateEmpEducationsByEmployeeId(List<EmpEducation> empEducations, String empId) {		
		this.empEducationDao.updateEmpEducationsByEmployeeId(empEducations, empId);
	}

	@Override
	@Transactional(readOnly = true, value = "jdbcTransactionManager")
	public List<EmpEducation> listEmpEducationsByEmployeeId(String employeeId) {
		return this.empEducationDao.listEmpEducationsByEmployeeId(employeeId);
	}

	@Override
	@Transactional(readOnly = true, value = "jdbcTransactionManager")
	public EmpEducation getEmpEducationById(String id) {
		return this.empEducationDao.getEmpEducationById(id);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public int removeEmpEducation(String employeeId, String educationId) {
		return this.empEducationDao.removeEmpEducation(employeeId, educationId);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public int removeEmpEducations(String employeeId, Set<String> educationIds) {
		return this.empEducationDao.removeEmpEducations(employeeId, educationIds);
	}

}
