package com.pmt.service;

import java.util.List;

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
	@Transactional
	public void addEmpEducation(EmpEducation empEducation, String empId) {		
		empEducation.setEmpId(empId);
		this.empEducationDao.addEmpEducation(empEducation);
	}

	@Override
	@Transactional
	public void updateEmpEducation(EmpEducation empEducation) {
		this.empEducationDao.updateEmpEducation(empEducation);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmpEducation> listEmpEducations() {
		return this.empEducationDao.listEmpEducations();
	}

	@Override
	@Transactional(readOnly = true)
	public EmpEducation getEmpEducationById(String id) {
		return this.empEducationDao.getEmpEducationById(id);
	}

	@Override
	@Transactional
	public void removeEmpEducation(String id) {
		this.empEducationDao.removeEmpEducation(id);
	}

}
