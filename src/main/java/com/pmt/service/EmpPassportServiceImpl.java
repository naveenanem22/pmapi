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
	public void addPassport(EmpPassport empPassport, int employeeId) {
		empPassportDao.addPassport(empPassport, employeeId);

	}

	@Override
	public EmpPassport getPassport(int employeeId) {
		return empPassportDao.getPassport(employeeId);
	}

	@Override
	public void updatePassport(EmpPassport empPassport, int employeeId) {
		empPassportDao.updatePassport(empPassport, employeeId);

	}

	@Override
	public void removePassport(int employeeId) {
		empPassportDao.removePassport(employeeId);

	}

}
