package com.pmt.dao;

import java.util.List;
import java.util.Set;

import com.pmt.model.EmpAddress;

public interface EmpAddressDao {

	List<EmpAddress> listEmpAddresses(String employeeId);

	void addEmpAddresses(String employeeId, Set<EmpAddress> empAddresses);

	void updateEmpAddresses(String employeeId, Set<EmpAddress> empAddresses);

	void removeEmpAddresses(String employeeId, Set<EmpAddress> empAddresses);

}
