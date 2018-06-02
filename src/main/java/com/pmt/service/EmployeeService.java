package com.pmt.service;

import java.util.List;

import com.pmt.model.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public List<Employee> listEmployees();
    public Employee getEmployeeById(String id);    
    public void removeEmployee(String id);

}
