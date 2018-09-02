package com.pmt.service;

import com.pmt.model.EmpPassport;

public interface EmpPassportService {

	void addPassport(EmpPassport empPassport, String employeeId);

	EmpPassport getPassport(String employeeId);

	void updatePassport(EmpPassport empPassport, String employeeId);

	void removePassport(String employeeId, String passportNumber);

}
