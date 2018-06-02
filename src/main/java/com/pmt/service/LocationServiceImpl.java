package com.pmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.LocationDao;
import com.pmt.model.Location;


@Service(value="locationServiceImpl")
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	@Qualifier("locationDaoImpl")
	private LocationDao locationDao;

	@Override
	@Transactional
	public void addLocation(Location location) {
		locationDao.addLocation(location);
		
	}

	@Override
	@Transactional
	public void updateLocation(Location location) {
		
		locationDao.updateLocation(location);
	}

	@Override
	@Transactional
	public List<Location> listLocations() {
		
		return locationDao.listLocations();
	}

	@Override
	@Transactional
	public Location getLocationById(int id) {
		
		return locationDao.getLocationById(id);
	}

	@Override
	@Transactional
	public void removeLocation(int id) {
		
		locationDao.removeLocation(id);
	}

	@Override
	@Transactional
	public Location getLocationByCity(String city) {
		
		return locationDao.getLocationByCity(city);
	}

	

		
	

}
