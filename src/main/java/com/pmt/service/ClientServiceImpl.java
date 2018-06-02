package com.pmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.ClientDao;
import com.pmt.model.Client;


@Service(value="clientServiceImpl")
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	@Qualifier("clientDaoImpl")
	private ClientDao clientDao;

	@Override
	@Transactional
	public void addClient(Client client) {
		clientDao.addClient(client);
		
	}

	@Override
	@Transactional
	public void updateClient(Client client) {
		
		clientDao.updateClient(client);
	}

	@Override
	@Transactional
	public List<Client> listClients() {
		
		return clientDao.listClients();
	}

	@Override
	@Transactional
	public Client getClientById(int id) {
		
		return clientDao.getClientById(id);
	}

	@Override
	@Transactional
	public void removeClient(int id) {
		
		clientDao.removeClient(id);
	}

	@Override
	@Transactional
	public List<Client> getClientsByName(String name) {
		
		return clientDao.getClientsByName(name);
	}

	@Override
	@Transactional
	public List<Client> getClientsById(int id) {
		
		return clientDao.getClientsById(id);
	}

		
	

}
