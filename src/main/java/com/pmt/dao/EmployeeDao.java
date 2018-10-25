package com.pmt.dao;

import java.util.List;

import com.pmt.model.Employee;

public interface EmployeeDao {
	
	public void addEmployee(Employee employee, int employeeId);
    public void updateEmployee(Employee employee, int employeeId);
    public List<Employee> listEmployees();
    public Employee getEmployeeById(int employeeId);
    public void removeEmployee(int employeeId);
    public List<Employee> getEmployeesByName(String name);    

}
