package com.pmt.dao;

import java.util.List;

import com.pmt.model.EmpEducation;

public interface EmpEducationDao {
	
	public void addEmpEducation(EmpEducation empEducation);
    public void updateEmpEducation(EmpEducation empEducation);
    public List<EmpEducation> listEmpEducations();
    public EmpEducation getEmpEducationById(String id);
    public void removeEmpEducation(String id);        

}
