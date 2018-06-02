package com.pmt.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pmt.model.Deliveryunit;

@Repository(value="deliveryunitDaoImpl")
public class DeliveryunitDaoImpl implements DeliveryunitDao {

	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addDeliveryunit(Deliveryunit deliveryunit) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(deliveryunit);
		
	}

	@Override
	public void updateDeliveryunit(Deliveryunit deliveryunit) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(deliveryunit);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deliveryunit> listDeliveryunits() {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Deliveryunit> deliveryunitList = session.createQuery("from Deliveryunit").list();
		return deliveryunitList;
	}

	@Override
	public Deliveryunit getDeliveryunitById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Deliveryunit deliveryunit  = (Deliveryunit) session.load(Deliveryunit.class, new Integer(id));		
		return deliveryunit;
		
	}

	@Override
	public void removeDeliveryunit(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Deliveryunit deliveryunit = (Deliveryunit) session.load(Deliveryunit.class, new Integer(id));
		if(null!=deliveryunit){
			session.delete(deliveryunit);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deliveryunit> getDeliveryunitsById(int id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Deliveryunit AS du WHERE du.id = :deliveryunitid");
		query.setParameter("deliveryunitid", id);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deliveryunit> getDeliveryunitsByName(String name) {
		name = "%"+name+"%";
        Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Deliveryunit AS du WHERE du.name like :deliveryunitname");
		query.setParameter("deliveryunitname", name);		
		return query.list();
	}
	
	
	

}
