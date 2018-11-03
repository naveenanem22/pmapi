package com.pmt.service;

import com.pmt.model.EmpPassport;

public interface EmpPassportService {

	void addPassport(EmpPassport empPassport, int employeeId);

	EmpPassport getPassport(int employeeId);

	void updatePassport(EmpPassport empPassport, int employeeId);

	void removePassport(int employeeId);

}
