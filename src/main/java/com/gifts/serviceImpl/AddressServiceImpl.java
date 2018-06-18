package com.gifts.serviceImpl;

import java.util.List;

import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gifts.dao.AddressDao;
import com.gifts.entity.Address;
import com.gifts.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;

	@Autowired
	@Qualifier("addressValidator")
	private Validator validator;

	public void save(Address address) throws Exception {
		validator.validate(address);
		addressDao.save(address);

	}

	public List<Address> findAll() {
		return addressDao.findAll();
	}

	public Address findOne(int id) {
		return addressDao.findOne(id);
	}

	public void delete(int id) {
		addressDao.delete(id);
	}

	public void update(Address address) {
		addressDao.save(address);
	}

	@Override
	public Address findByStreet(String street) {
		return addressDao.findByStreet(street);
	}
}
