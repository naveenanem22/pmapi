package com.pmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.BusinessunitDao;
import com.pmt.model.Businessunit;


@Service(value="businessunitServiceImpl")
public class BusinessunitServiceImpl implements BusinessunitService {
	
	@Autowired
	@Qualifier("businessunitDaoImpl")
	private BusinessunitDao businessunitDao;

	@Override
	@Transactional
	public void addBusinessunit(Businessunit businessunit) {
		businessunitDao.addBusinessunit(businessunit);
		
	}

	@Override
	@Transactional
	public void updateBusinessunit(Businessunit businessunit) {
		
		businessunitDao.updateBusinessunit(businessunit);
	}

	@Override
	@Transactional
	public List<Businessunit> listBusinessunits() {
		
		return businessunitDao.listBusinessunits();
	}

	@Override
	@Transactional
	public Businessunit getBusinessunitById(int id) {
		
		return businessunitDao.getBusinessunitById(id);
	}

	@Override
	@Transactional
	public void removeBusinessunit(int id) {
		
		businessunitDao.removeBusinessunit(id);
	}

	@Override
	@Transactional
	public List<Businessunit> getBusinessunitsById(int id) {
		
		return businessunitDao.getBusinessunitsById(id);
	}

	@Override
	@Transactional
	public List<Businessunit> getBusinessunitsByName(String name) {
		
		return businessunitDao.getBusinessunitsByName(name);
	}

		
	

}
