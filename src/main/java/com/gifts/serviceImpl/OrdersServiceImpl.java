package com.gifts.serviceImpl;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import com.gifts.dao.*;
import com.gifts.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gifts.service.OrdersService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private SuitOfDeliveryDao suitOfDeliveryDao;

	public void save(Orders orders, Address address) {
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

	@Override
	public void addIntoBasket(Principal principal, int id) {

		User user = userDao.findUserWithCommodity(Integer.parseInt(principal.getName()));

		Commodity commodity = commodityDao.findOne(id);

		user.getCommodities().add(commodity);

		userDao.save(user);
	}

	@Override
	@Transactional
	public void deleteFromBasket(int userId, int commodityId) {

		User user = userDao.findUserWithCommodity(userId);

		Commodity commodity = commodityDao.findOne(commodityId);

		user.getCommodities().remove(commodity);

		userDao.save(user);

	}


	@Override
	@Transactional
	public void buy(int userId, Address address, int suit, String description) {

		Orders orders = new Orders(LocalDate.now());




//		Orders orders = new Orders();

		addressDao.saveAndFlush(address);

		ordersDao.saveAndFlush(orders);


		orders.setAddress(address);


		User user = userDao.findUserWithCommodity(userId);

		SuitOfDelivery suitOfDelivery = suitOfDeliveryDao.findOne(suit);

		orders.setUser(user);

		orders.setDelivery(suitOfDelivery);

		orders.setDescription(description);


			for (Commodity commodity : user.getCommodities()) {

			orders.getCommodities().add(commodity);

			ordersDao.save(orders);

		}

		user.getCommodities().clear();
		userDao.save(user);
	}


}
