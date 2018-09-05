package com.pmt.dao;

import java.util.List;

import com.pmt.model.Employee;

public interface EmployeeDao {
	
	public void addEmployee(Employee employee, String employeeId);
    public void updateEmployee(Employee employee, String employeeId);
    public List<Employee> listEmployees();
    public Employee getEmployeeById(String id);
    public void removeEmployee(String id);
    public List<Employee> getEmployeesByName(String name);    

}
