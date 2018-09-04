package com.pmt.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.EmpAddressDao;
import com.pmt.model.EmpAddress;

@Service(value = "empAddressServiceImpl")
public class EmpAddressServiceImpl implements EmpAddressService {

	@Autowired
	@Qualifier(value = "empAddressDaoImpl")
	private EmpAddressDao empAddressDao;

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public List<EmpAddress> listEmpAddresses(String employeeId) {
		return empAddressDao.listEmpAddresses(employeeId);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public void addEmpAddresses(String employeeId, Set<EmpAddress> empAddresses) {
		empAddressDao.addEmpAddresses(employeeId, empAddresses);

	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public void updateEmpAddresses(String employeeId, Set<EmpAddress> empAddresses) {
		empAddressDao.updateEmpAddresses(employeeId, empAddresses);

	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public void removeEmpAddresses(String employeeId, Set<EmpAddress> empAddresses) {
		empAddressDao.removeEmpAddresses(employeeId, empAddresses);

	}

}
