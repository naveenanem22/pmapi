package com.pmt.service;

import java.util.List;
import java.util.Set;

import com.pmt.model.Visa;

public interface VisaService {
	
	public void addVisa(Visa visa, String id);
    public void updateVisasByEmployeeId(List<Visa> visas, String employeeId);
    public List<Visa> listVisasByEmployeeId(String employeeId);
    public Visa getVisaById(String id);    
    public int removeVisa(String employeeId, String visaId);
    public int removeVisas(String employeeId, Set<String> visaIds);

}
