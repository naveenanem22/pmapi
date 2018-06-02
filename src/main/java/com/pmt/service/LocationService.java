package com.pmt.service;

import java.util.List;

import com.pmt.model.Location;
import com.pmt.model.Skill;

public interface LocationService {
	
	public void addLocation(Location location);
    public void updateLocation(Location location);
    public List<Location> listLocations();
    public Location getLocationById(int id);
    public Location getLocationByCity(String city);
    public void removeLocation(int id);
    

}
