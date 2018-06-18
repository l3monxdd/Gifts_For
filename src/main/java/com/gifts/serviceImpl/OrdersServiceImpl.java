package com.gifts.serviceImpl;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import com.gifts.dao.*;
import com.gifts.entity.*;
import com.gifts.validator.UserValidator.UserException;
import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

	@Autowired
	@Qualifier("profileValidator")
	private Validator validator;

	@Override
	public void save(Orders orders) {
		ordersDao.save(orders);
	}

	@Autowired
	private CommodityCounterDao commodityCounterDao;

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
	public void buy(int userId, Address address, int suit, String description, List<Integer> counters) throws Exception {
		validator.validate(address);

		User user = userDao.findUserWithCommodity(userId);

		for (int i = 0; i < user.getCommodities().size(); i++) {
			if(user.getCommodities().get(i).getQuantity() < counters.get(i)){
				throw new UserException(user.getCommodities().get(i).getName_of_commodity()+" quantity = "
						+user.getCommodities().get(i).getQuantity()+" but you ordered "+counters.get(i));
			}
		}

		Orders orders = new Orders(LocalDate.now());

		addressDao.saveAndFlush(address);

		ordersDao.saveAndFlush(orders);

		orders.setAddress(address);


		SuitOfDelivery suitOfDelivery = suitOfDeliveryDao.findOne(suit);

		orders.setUser(user);

		orders.setDelivery(suitOfDelivery);

		orders.setDescription(description);

		for (int i = 0; i < counters.size(); i++) {

			CommodityCounter commodityCounter = new CommodityCounter();

			commodityCounterDao.saveAndFlush(commodityCounter);

			commodityCounter.setOrders(orders);

			commodityCounter.setCommodity(user.getCommodities().get(i));

			commodityCounter.setCounter(counters.get(i));
		}


		for (Commodity commodity : user.getCommodities()) {

			orders.getCommodities().add(commodity);

			ordersDao.save(orders);

		}

		user.getCommodities().clear();
		userDao.save(user);
	}

	@Override
	public List<Orders> ordersWithCommodities() {
		return ordersDao.ordersWithCommodities();
	}

	@Override
	public List<Orders> ordersWithCommodityCouters() {
		return ordersDao.ordersWithCommodityCounters();
	}

	@Override
	public void orderIsDone(List<Boolean> done) {
		List<Orders> orders = ordersDao.findAll();

		for (int i = 0; i < done.size(); i++) {

			orders.get(i).setDone(done.get(i));
			ordersDao.save(orders.get(i));
		}
	}
}
