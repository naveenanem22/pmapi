package com.pmt.dao;

import com.pmt.model.EmpPassport;

public interface EmpPassportDao {

	void addPassport(EmpPassport empPassport, int employeeId);

	EmpPassport getPassport(int employeeId);

	void updatePassport(EmpPassport empPassport, int employeeId);

	void removePassport(int employeeId);

}
