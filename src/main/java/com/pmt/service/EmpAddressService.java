package com.pmt.service;

import java.util.List;

import com.pmt.model.IndividualAddress;

public interface EmpAddressService {
	
	List<IndividualAddress> getEmployeeAddressesByEmployeeId(int employeeId);
	boolean addEmployeeAddressByEmployeeId(IndividualAddress personalAddress, int employeeId);

}
