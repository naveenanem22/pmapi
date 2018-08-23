package com.pmt.dao;

import java.util.List;
import java.util.Set;

import com.pmt.model.Visa;

public interface VisaDao {
	
	public void addVisa(Visa visa, String employeeId);
    public void updateVisasByEmployeeId(List<Visa> visas, String employeeId);
    public List<Visa> listVisasByEmployeeId(String employeeId);
    public Visa getVisaById(String id);
    public int removeVisa(String employeeId, String visaId); 
    public int removeVisas(String employeeId, Set<String> visas);

}
