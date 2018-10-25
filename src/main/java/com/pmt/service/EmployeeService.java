package com.pmt.service;

import java.util.List;

import com.pmt.model.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee, int employeeId);
    public List<Employee> listEmployees();
    public Employee getEmployeeById(int employeeId);    
    public void removeEmployee(int employeeId);

}
