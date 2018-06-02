package com.pmt.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pmt.model.Client;

@Repository(value="clientDaoImpl")
public class ClientDaoImpl implements ClientDao {

	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addClient(Client client) {
		Session session = this.sessionFactory.getCurrentSession();
		//session.persist(client);
		session.saveOrUpdate(client);
		
	}

	@Override
	public void updateClient(Client client) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(client);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> listClients() {
		
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Client AS cl where cl.isDeleted = false");
		/*List<Client> clientList = session.createQuery("from Client AS cl where cl.isDeleted = false").list();
		return clientList;*/
		return query.list();
	}

	@Override
	public Client getClientById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Client client  = (Client) session.load(Client.class, new Integer(id));		
		return client;
		
	}

	@Override
	public void removeClient(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Client client = (Client) session.load(Client.class, new Integer(id));
		
		if(null!=client){
			/*session.delete(client);*//* removed this line to enable soft delete functionality*/
			client.setDeleted(true);
			session.update(client);
			
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getClientsByName(String name) {
		
		 name = "%"+name+"%";
	        Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM Client AS cl WHERE cl.name like :clientname and cl.isDeleted = false");
			query.setParameter("clientname", name);		
			return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getClientsById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Client AS cl WHERE cl.id = :clientid and cl.isDeleted = false");
		query.setParameter("clientid", id);
		return query.list();
		
	}
	
	
	

}
