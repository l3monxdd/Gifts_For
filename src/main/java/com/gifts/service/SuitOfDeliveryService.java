package com.gifts.service;

import java.util.List;

import com.gifts.entity.SuitOfDelivery;
import org.springframework.web.multipart.MultipartFile;

public interface SuitOfDeliveryService {

	void save(SuitOfDelivery suitOfDelivery, MultipartFile image) throws Exception;

	List<SuitOfDelivery> findAll();

	SuitOfDelivery findOne(int id);

	void delete(int id);

	void update(SuitOfDelivery suitOfDelivery, MultipartFile image);

	SuitOfDelivery findByName (String name);

}
