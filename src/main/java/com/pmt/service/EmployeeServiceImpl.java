package com.pmt.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.EmployeeDao;
import com.pmt.model.Employee;

@Service(value="employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	@Qualifier(value="employeeDaoImpl")
	private EmployeeDao employeeDao;

	@Override
	@Transactional(value="hibernateTransactionManager")
	public void addEmployee(Employee employee) {
		this.employeeDao.addEmployee(employee);
	}

	@Override
	@Transactional(value="hibernateTransactionManager")
	public void updateEmployee(Employee employee) {
		this.employeeDao.updateEmployee(employee);
	}

	@Override
	@Transactional(readOnly = true, value="hibernateTransactionManager")
	public List<Employee> listEmployees() {
		return this.employeeDao.listEmployees();
	}

	@Override
	@Transactional(readOnly = true, value="hibernateTransactionManager")
	public Employee getEmployeeById(String id) {		
		return this.employeeDao.getEmployeeById(id);
	}
	

	@Override
	@Transactional(value="hibernateTransactionManager")
	public void removeEmployee(String id) {
		this.employeeDao.removeEmployee(id);
	}

}
