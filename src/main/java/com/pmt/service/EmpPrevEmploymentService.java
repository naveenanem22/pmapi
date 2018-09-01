package com.pmt.service;

import java.util.List;
import java.util.Set;

import com.pmt.model.EmpPrevEmployment;

public interface EmpPrevEmploymentService {
	int addPrevEmployments(String employeeId, Set<EmpPrevEmployment> empPrevEmployments);

	int updatePrevEmployments(String employeeId, Set<EmpPrevEmployment> empPrevEmployments);

	int removePrevEmployments(String employeeId, Set<EmpPrevEmployment> empPrevEmployments);

	List<EmpPrevEmployment> listPrevEmploymentsByEmployeeId(String employeeId);
}
