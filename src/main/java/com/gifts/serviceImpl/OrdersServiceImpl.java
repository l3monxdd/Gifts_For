package com.gifts.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gifts.dao.OrdersDao;
import com.gifts.entity.Orders;
import com.gifts.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao ordersDao;

	public void save(Orders orders) {
		ordersDao.save(orders);
	}

	public List<Orders> findAll() {
		return ordersDao.findAll();
	}

	public Orders findOne(int id) {
		return ordersDao.findOne(id);
	}

	public void delete(int id) {
		ordersDao.delete(id);
	}

	public void update(Orders orders) {
		ordersDao.save(orders);
	}

}
