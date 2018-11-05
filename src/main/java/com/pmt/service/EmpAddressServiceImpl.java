package com.pmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.EmpAddressDao;
import com.pmt.model.IndividualAddress;

@Service(value = "empAddressServiceImpl")
public class EmpAddressServiceImpl implements EmpAddressService {

	@Autowired
	@Qualifier(value = "empAddressDaoImpl")
	private EmpAddressDao empAddressDao;

	@Override
	@Transactional(readOnly = true)
	public List<IndividualAddress> getEmployeeAddressesByEmployeeId(int employeeId) {
		return empAddressDao.getEmployeeAddressesByEmployeeId(employeeId);
	}

	@Override
	public boolean addEmployeeAddressByEmployeeId(IndividualAddress personalAddress, int employeeId) {
		return empAddressDao.addEmployeeAddress(personalAddress, employeeId);
	}

}
