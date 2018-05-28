package com.pmt.dao;

import java.util.List;

import com.pmt.model.Businessunit;


public interface BusinessunitDao {
	
	public void addBusinessunit(Businessunit businessunit);
    public void updateBusinessunit(Businessunit businessunit);
    public List<Businessunit> listBusinessunits();
    public Businessunit getBusinessunitById(int id);
    public void removeBusinessunit(int id);
    public List<Businessunit> getBusinessunitsByName(String name);
    public List<Businessunit> getBusinessunitsById(int id);
	

}
