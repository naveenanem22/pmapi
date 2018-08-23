package com.pmt.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pmt.dao.VisaDao;
import com.pmt.model.Visa;

@Service(value = "visaServiceImpl")
public class VisaServiceImpl implements VisaService {

	@Autowired
	@Qualifier(value = "visaDaoImpl")
	private VisaDao visaDao;

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public void addVisa(Visa visa, String employeeId) {
		this.visaDao.addVisa(visa, employeeId);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public void updateVisasByEmployeeId(List<Visa> visas, String employeeId) {
		this.visaDao.updateVisasByEmployeeId(visas, employeeId);
	}

	@Override
	@Transactional(readOnly = true, value = "jdbcTransactionManager")
	public List<Visa> listVisasByEmployeeId(String employeeId) {
		return this.visaDao.listVisasByEmployeeId(employeeId);
	}

	@Override
	@Transactional(readOnly = true, value = "jdbcTransactionManager")
	public Visa getVisaById(String id) {
		return this.visaDao.getVisaById(id);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public int removeVisa(String employeeId, String educationId) {
		return this.visaDao.removeVisa(employeeId, educationId);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public int removeVisas(String employeeId, Set<String> educationIds) {
		return this.visaDao.removeVisas(employeeId, educationIds);
	}

}
