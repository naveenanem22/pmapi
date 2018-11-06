package com.pmt.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	
	private static final Logger logger = LogManager.getLogger(EmpAddressServiceImpl.class);

	@Override
	@Transactional(readOnly = true, value = "jdbcTransactionManager")
	public List<IndividualAddress> getEmployeeAddressesByEmployeeId(int employeeId) {
		logger.debug("Received employeeId from Controller: "+employeeId);		
		return empAddressDao.getEmployeeAddressesByEmployeeId(employeeId);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public boolean addEmployeeAddressByEmployeeId(IndividualAddress personalAddress, int employeeId) {
		return empAddressDao.addEmployeeAddress(personalAddress, employeeId);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public boolean updateEmployeeAddressByEmployeeId(IndividualAddress employeeAddress, int employeeId) {
		return empAddressDao.updateEmployeeAddress(employeeAddress, employeeId);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public boolean removeEmployeeAddress(int employeeAddressId, int employeeId) {
		return empAddressDao.removeEmployeeAddress(employeeAddressId, employeeId);
	}

}
