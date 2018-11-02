package com.pmt.dao;

import java.util.List;

import com.pmt.model.PersonalAddress;

public interface EmpAddressDao {
	
	List<PersonalAddress> getEmployeeAddressesByEmployeeId(int employeeId);
	boolean addEmployeeAddress(PersonalAddress employeeAddress);
	boolean updateEmployeeAddress(PersonalAddress employeeAddress);	

}
