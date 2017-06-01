package com.gifts.service;

import java.util.List;

import com.gifts.entity.SuitOfDelivery;

public interface SuitOfDeliveryService {

	void save(SuitOfDelivery suitOfDelivery) throws Exception;

	List<SuitOfDelivery> findAll();

	SuitOfDelivery findOne(int id);

	void delete(int id);

	void update(SuitOfDelivery suitOfDelivery);

	SuitOfDelivery findByName (String name);

}
