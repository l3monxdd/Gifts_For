package com.gifts.service;

import java.util.List;

import com.gifts.entity.Address;

public interface AddressService {
	void save(Address address) throws Exception;

	List<Address> findAll();

	Address findOne(int id);

	void delete(int id);

	void update(Address address);

	Address findByStreet(String street);

}
