package com.pmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.DeliveryunitDao;
import com.pmt.model.Deliveryunit;


@Service(value="deliveryunitServiceImpl")
public class DeliveryunitServiceImpl implements DeliveryunitService {
	
	@Autowired
	@Qualifier("deliveryunitDaoImpl")
	private DeliveryunitDao deliveryunitDao;

	@Override
	@Transactional
	public void addDeliveryunit(Deliveryunit deliveryunit) {
		deliveryunitDao.addDeliveryunit(deliveryunit);
		
	}

	@Override
	@Transactional
	public void updateDeliveryunit(Deliveryunit deliveryunit) {
		
		deliveryunitDao.updateDeliveryunit(deliveryunit);
	}

	@Override
	@Transactional
	public List<Deliveryunit> listDeliveryunits() {
		
		return deliveryunitDao.listDeliveryunits();
	}

	@Override
	@Transactional
	public Deliveryunit getDeliveryunitById(int id) {
		
		return deliveryunitDao.getDeliveryunitById(id);
	}

	@Override
	@Transactional
	public void removeDeliveryunit(int id) {
		
		deliveryunitDao.removeDeliveryunit(id);
	}

	@Override
	@Transactional
	public List<Deliveryunit> getDeliveryunitsById(int id) {
		
		return deliveryunitDao.getDeliveryunitsById(id);
	}

	@Override
	@Transactional
	public List<Deliveryunit> getDeliveryunitsByName(String name) {
		
		return deliveryunitDao.getDeliveryunitsByName(name);
	}

		
	

}
