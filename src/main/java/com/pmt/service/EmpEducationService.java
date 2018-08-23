package com.pmt.service;

import java.util.List;

import com.pmt.model.EmpEducation;

public interface EmpEducationService {
	
	public void addEmpEducation(EmpEducation empEducation, String id);
    public void updateEmpEducationsByEmployeeId(List<EmpEducation> empEducations, String empId);
    public List<EmpEducation> listEmpEducationsByEmployeeId(String employeeId);
    public EmpEducation getEmpEducationById(String id);    
    public int removeEmpEducation(String employeeId, String educationId);

}
