package com.pmt.dao;

import java.util.List;

import com.pmt.model.EmpEducation;

public interface EmpEducationDao {
	
	public void addEmpEducation(EmpEducation empEducation);
    public void updateEmpEducationsByEmployeeId(List<EmpEducation> empEducations, String empId);
    public List<EmpEducation> listEmpEducationsByEmployeeId(String employeeId);
    public EmpEducation getEmpEducationById(String id);
    public void removeEmpEducation(String id);        

}
