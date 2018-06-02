package com.pmt.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pmt.model.Location;

@Repository(value="locationDaoImpl")
public class LocationDaoImpl implements LocationDao {

	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addLocation(Location location) {
		Session session = this.sessionFactory.getCurrentSession();
		//session.persist(location);
		session.saveOrUpdate(location);
		
	}

	@Override
	public void updateLocation(Location location) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(location);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> listLocations() {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Location> locationList = session.createQuery("from Location").list();
		return locationList;
	}

	@Override
	public Location getLocationById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Location location  = (Location) session.load(Location.class, new Integer(id));		
		return location;
		
	}

	@Override
	public void removeLocation(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Location location = (Location) session.load(Location.class, new Integer(id));
		if(null!=location){
			session.delete(location);
		}
		
	}

	@Override	
	public Location getLocationByCity(String city) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Location AS loc WHERE loc.city = :loc_city");
		query.setParameter("loc_city", city);
		Location location = (Location) query.list().get(0);
		System.out.println(location.getId());
		System.out.println(location.getCity());
		System.out.println(location.getState());
		return location;
	}

	
	
	

}
