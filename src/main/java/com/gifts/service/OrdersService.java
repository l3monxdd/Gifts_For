package com.gifts.service;

import java.util.List;

import com.gifts.entity.Orders;

public interface OrdersService {
	void save(Orders orders);

	List<Orders> findAll();

	Orders findOne(int id);

	void delete(int id);

	void update(Orders orders);

}
