package com.pmt.dao;

import java.util.List;

import com.pmt.model.Employee;

public interface EmployeeDao {
	
	public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public List<Employee> listEmployees();
    public Employee getEmployeeById(String id);
    public void removeEmployee(String id);
    public List<Employee> getEmployeesByName(String name);    

}
