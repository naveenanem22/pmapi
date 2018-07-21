package com.pmt.service;

import java.util.List;

import com.pmt.model.EmpEducation;

public interface EmpEducationService {
	
	public void addEmpEducation(EmpEducation empEducation, String id);
    public void updateEmpEducation(EmpEducation empEducation);
    public List<EmpEducation> listEmpEducations();
    public EmpEducation getEmpEducationById(String id);    
    public void removeEmpEducation(String id);

}
