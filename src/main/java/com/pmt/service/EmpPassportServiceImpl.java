package com.pmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmt.dao.EmpPassportDao;
import com.pmt.model.EmpPassport;

@Service(value = "empPassportServiceImpl")
public class EmpPassportServiceImpl implements EmpPassportService {

	@Autowired
	@Qualifier(value = "empPassportDaoImpl")
	private EmpPassportDao empPassportDao;

	@Override
	public void addPassport(EmpPassport empPassport, String employeeId) {
		empPassportDao.addPassport(empPassport, employeeId);

	}

	@Override
	public EmpPassport getPassport(String employeeId) {
		return empPassportDao.getPassport(employeeId);
	}

	@Override
	public void updatePassport(EmpPassport empPassport, String employeeId) {
		empPassportDao.updatePassport(empPassport, employeeId);

	}

	@Override
	public void removePassport(String employeeId, String passportNumber) {
		empPassportDao.removePassport(employeeId, passportNumber);

	}

}
