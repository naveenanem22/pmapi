package com.pmt.dao;

import java.util.List;

import com.pmt.model.IndividualAddress;

public interface EmpAddressDao {

	List<IndividualAddress> getEmployeeAddressesByEmployeeId(int employeeId);

	boolean addEmployeeAddress(IndividualAddress employeeAddress, int employeeId);

	boolean updateEmployeeAddress(IndividualAddress employeeAddress, int employeeId);

	boolean removeEmployeeAddress(int employeeAddressId, int employeeId);

}
