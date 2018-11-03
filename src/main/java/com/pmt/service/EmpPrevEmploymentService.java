package com.pmt.service;

import java.util.List;
import java.util.Set;

import com.pmt.model.EmpPrevEmployment;

public interface EmpPrevEmploymentService {
	int addPrevEmployments(int employeeId, Set<EmpPrevEmployment> empPrevEmployments);

	int updatePrevEmployments(int employeeId, Set<EmpPrevEmployment> empPrevEmployments);

	int removePrevEmployments(int employeeId, Set<EmpPrevEmployment> empPrevEmployments);

	List<EmpPrevEmployment> listPrevEmploymentsByEmployeeId(int employeeId);
}
