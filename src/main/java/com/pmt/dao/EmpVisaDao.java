package com.pmt.dao;

import java.util.List;
import java.util.Set;

import com.pmt.model.EmpVisa;

public interface EmpVisaDao {
	
	public void addVisa(EmpVisa visa, int employeeId);
    public void updateVisasByEmployeeId(List<EmpVisa> visas, int employeeId);
    public List<EmpVisa> listVisasByEmployeeId(int employeeId);
    public EmpVisa getVisaById(int visaId);
    public int removeVisa(int employeeId, int visaId); 
    public int removeVisas(int employeeId, Set<Integer> visaIds);

}
