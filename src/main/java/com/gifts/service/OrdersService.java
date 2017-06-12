package com.gifts.service;

import java.security.Principal;
import java.util.List;

import com.gifts.entity.Orders;

public interface OrdersService {
	void save(Orders orders);

	List<Orders> findAll();

	Orders findOne(int id);

	void delete(int id);

	void update(Orders orders);

	void addIntoBasket (Principal principal, int id);


	void deleteFromBasket(int userId, int commodityId);

	void buy(int userId);
}
