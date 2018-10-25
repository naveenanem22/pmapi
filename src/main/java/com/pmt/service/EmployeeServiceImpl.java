package com.pmt.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.EmployeeDao;
import com.pmt.model.Employee;

@Service(value = "employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier(value = "employeeDaoImpl")
	private EmployeeDao employeeDao;

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public void addEmployee(Employee employee) {
		this.employeeDao.addEmployee(employee, 123456);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public void updateEmployee(Employee employee, int employeeId) {
		this.employeeDao.updateEmployee(employee, employeeId);
	}

	@Override
	@Transactional(readOnly = true, value = "jdbcTransactionManager")
	public List<Employee> listEmployees() {
		return this.employeeDao.listEmployees();
	}

	@Override
	@Transactional(readOnly = true, value = "jdbcTransactionManager")
	public Employee getEmployeeById(int employeeId) {
		return this.employeeDao.getEmployeeById(employeeId);
	}

	@Override
	@Transactional(value = "jdbcTransactionManager")
	public void removeEmployee(int employeeId) {
		this.employeeDao.removeEmployee(employeeId);
	}

}
