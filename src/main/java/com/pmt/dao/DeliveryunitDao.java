package com.pmt.dao;

import java.util.List;

import com.pmt.model.Businessunit;
import com.pmt.model.Deliveryunit;

public interface DeliveryunitDao {
	
	public void addDeliveryunit(Deliveryunit deliveryunit);
    public void updateDeliveryunit(Deliveryunit deliveryunit);
    public List<Deliveryunit> listDeliveryunits();
    public Deliveryunit getDeliveryunitById(int id);
    public void removeDeliveryunit(int id);
    public List<Deliveryunit> getDeliveryunitsById(int id);
    public List<Deliveryunit> getDeliveryunitsByName(String name);
	

}
