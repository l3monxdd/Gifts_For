package com.gifts.serviceImpl;

import java.util.List;

import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gifts.dao.SuitOfDeliveryDao;
import com.gifts.entity.SuitOfDelivery;
import com.gifts.service.SuitOfDeliveryService;

@Service
public class SuitOfDeliveryServiceImpl implements SuitOfDeliveryService {


	@Autowired
	private SuitOfDeliveryDao suitOfDeliveryDao;

	@Autowired
	@Qualifier("suitOfDeliveryValidator")
	private Validator validator;

	public void save(SuitOfDelivery suitOfDelivery) throws Exception {
		validator.validate(suitOfDelivery);
		suitOfDeliveryDao.save(suitOfDelivery);
	}

	public List<SuitOfDelivery> findAll() {
		return suitOfDeliveryDao.findAll();
	}

	public SuitOfDelivery findOne(int id) {
		return suitOfDeliveryDao.findOne(id);
	}

	public void delete(int id) {
		suitOfDeliveryDao.delete(id);
	}

	public void update(SuitOfDelivery suitOfDelivery) {
		suitOfDeliveryDao.save(suitOfDelivery);
	}

//	@Override
//	public SuitOfDelivery findByName_of_suit(String name_of_suit) {
//		return suitOfDeliveryDao.findByName_of_suit(name_of_suit);
//	}

	@Override
	public SuitOfDelivery findByName(String name) {

		return suitOfDeliveryDao.findByName(name);
	}
}
