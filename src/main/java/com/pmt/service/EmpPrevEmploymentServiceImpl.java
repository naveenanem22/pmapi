package com.pmt.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmt.dao.EmpPrevEmploymentDao;
import com.pmt.model.EmpPrevEmployment;

@Service(value = "empPrevEmploymentServiceImpl")
public class EmpPrevEmploymentServiceImpl implements EmpPrevEmploymentService {

	@Autowired
	@Qualifier(value = "empPrevEmploymentDaoImpl")
	private EmpPrevEmploymentDao empPrevEmploymentDao;

	@Override
	public int addPrevEmployments(String employeeId, Set<EmpPrevEmployment> empPrevEmployments) {
		return empPrevEmploymentDao.addPrevEmployments(employeeId, empPrevEmployments);

	}

	@Override
	public int updatePrevEmployments(String employeeId, Set<EmpPrevEmployment> empPrevEmployments) {
		return empPrevEmploymentDao.updatePrevEmployments(employeeId, empPrevEmployments);
	}

	@Override
	public int removePrevEmployments(String employeeId, Set<EmpPrevEmployment> empPrevEmployments) {
		return empPrevEmploymentDao.removePrevEmployments(employeeId, empPrevEmployments);
	}

	@Override
	public List<EmpPrevEmployment> listPrevEmploymentsByEmployeeId(String employeeId) {
		return empPrevEmploymentDao.listPrevEmploymentsByEmployeeId(employeeId);
	}

}