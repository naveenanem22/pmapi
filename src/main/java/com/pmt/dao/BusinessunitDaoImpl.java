package com.pmt.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pmt.model.Businessunit;

@Repository(value="businessunitDaoImpl")
public class BusinessunitDaoImpl implements BusinessunitDao {

	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addBusinessunit(Businessunit businessunit) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(businessunit);
		
	}

	@Override
	public void updateBusinessunit(Businessunit businessunit) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(businessunit);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Businessunit> listBusinessunits() {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Businessunit> businessunitList = session.createQuery("from Businessunit").list();
		return businessunitList;
	}

	@Override
	public Businessunit getBusinessunitById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Businessunit businessunit  = (Businessunit) session.load(Businessunit.class, new Integer(id));		
		return businessunit;
		
	}

	@Override
	public void removeBusinessunit(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Businessunit businessunit = (Businessunit) session.load(Businessunit.class, new Integer(id));
		if(null!=businessunit){
			session.delete(businessunit);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Businessunit> getBusinessunitsByName(String name) {
		name = "%"+name+"%";
        Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Businessunit AS bu WHERE bu.name like :businessunitname");
		query.setParameter("businessunitname", name);		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Businessunit> getBusinessunitsById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Businessunit AS bu WHERE bu.id = :businessunitid");
		query.setParameter("businessunitid", id);
		return query.list();
	}
	
	
	

}
