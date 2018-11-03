package com.pmt.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.pmt.model.EmpPrevEmployment;

public interface EmpPrevEmploymentDao {
	int addPrevEmployments(int employeeId, Set<EmpPrevEmployment> empPrevEmployments);

	int updatePrevEmployments(int employeeId, Set<EmpPrevEmployment> empPrevEmployments);

	int removePrevEmployments(int employeeId, Set<EmpPrevEmployment> empPrevEmployments);

	List<EmpPrevEmployment> listPrevEmploymentsByEmployeeId(int employeeId);

}
