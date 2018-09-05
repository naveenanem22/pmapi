package com.pmt.service;

import java.util.List;

import com.pmt.model.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee, String employeeId);
    public List<Employee> listEmployees();
    public Employee getEmployeeById(String employeeId);    
    public void removeEmployee(String employeeId);

}
