package com.pmt.service;

import java.util.List;

import com.pmt.model.Businessunit;
import com.pmt.model.Skill;

public interface BusinessunitService {
	
	public void addBusinessunit(Businessunit businessunit);
    public void updateBusinessunit(Businessunit businessunit);
    public List<Businessunit> listBusinessunits();
    public Businessunit getBusinessunitById(int id);
    public List<Businessunit> getBusinessunitsById(int id);
    public List<Businessunit> getBusinessunitsByName(String name);
    public void removeBusinessunit(int id);
	

}
