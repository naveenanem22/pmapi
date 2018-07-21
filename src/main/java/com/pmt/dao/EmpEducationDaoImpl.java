package com.pmt.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.model.EmpEducation;
import com.pmt.model.Employee;

@Repository(value="empEducationDaoImpl")
public class EmpEducationDaoImpl implements EmpEducationDao {
	
	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

	@Override
	@Transactional
	public void addEmpEducation(EmpEducation empEducation) {
		Session session = this.sessionFactory.getCurrentSession();		
		session.saveOrUpdate(empEducation);
	}	
	

	@Override
	@Transactional
	public void updateEmpEducation(EmpEducation empEducation) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(empEducation);
	}

	@Override
	@Transactional(readOnly=true)
	public List<EmpEducation> listEmpEducations() {
		Session session = this.sessionFactory.getCurrentSession();
		//return Collections.checkedList(session.createQuery("from EmpEducation").list(), EmpEducation.class);
		return session.createQuery("from EmpEducation").list();
		
	}

	@Override
	@Transactional(readOnly=true)
	public EmpEducation getEmpEducationById(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.load(EmpEducation.class, id);		
	}

	@Override
	@Transactional
	public void removeEmpEducation(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(session.load(EmpEducation.class, id));
	}

	

}
