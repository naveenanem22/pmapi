package com.pmt.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.pmt.model.EmpPrevEmployment;

public interface EmpPrevEmploymentDao {
	int addPrevEmployments(String employeeId, Set<EmpPrevEmployment> empPrevEmployments);

	int updatePrevEmployments(String employeeId, Set<EmpPrevEmployment> empPrevEmployments);

	int removePrevEmployments(String employeeId, Set<EmpPrevEmployment> empPrevEmployments);

	List<EmpPrevEmployment> listPrevEmploymentsByEmployeeId(String employeeId);

}
