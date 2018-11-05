package com.pmt.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pmt.dao.EmpVisaDao;
import com.pmt.model.EmpVisa;

@Service(value = "visaServiceImpl")
public class VisaServiceImpl implements VisaService {

	@Autowired
	@Qualifier(value = "visaDaoImpl")
	private EmpVisaDao visaDao;

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public void addVisa(EmpVisa visa, int employeeId) {
		this.visaDao.addVisa(visa, employeeId);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public void updateVisasByEmployeeId(List<EmpVisa> visas, int employeeId) {
		this.visaDao.updateVisasByEmployeeId(visas, employeeId);
	}

	@Override
	@Transactional(readOnly = true, value = "jdbcTransactionManager")
	public List<EmpVisa> listVisasByEmployeeId(int employeeId) {
		return this.visaDao.listVisasByEmployeeId(employeeId);
	}

	@Override
	@Transactional(readOnly = true, value = "jdbcTransactionManager")
	public EmpVisa getVisaById(int visaId) {
		return this.visaDao.getVisaById(visaId);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public int removeVisa(int employeeId, int visaId) {
		return this.visaDao.removeVisa(employeeId, visaId);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public int removeVisas(int employeeId, Set<Integer> visaIds) {
		return this.visaDao.removeVisas(employeeId, visaIds);
	}

}
