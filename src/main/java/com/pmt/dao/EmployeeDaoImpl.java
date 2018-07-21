package com.pmt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.model.Employee;

@Repository(value="employeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

	@Override	
	public void addEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
	}	
	

	@Override	
	public void updateEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(employee);
	}

	@Override	
	public List<Employee> listEmployees() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Employee").list();
		
	}

	@Override	
	public Employee getEmployeeById(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Employee) session.load(Employee.class, id);		
	}

	@Override	
	public void removeEmployee(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(session.load(Employee.class, id));
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
