package com.gifts.serviceImpl;

import java.security.Principal;
import java.util.List;

import com.gifts.dao.CommodityDao;
import com.gifts.entity.Commodity;
import com.gifts.entity.Role;
import com.gifts.service.CommodityService;
import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gifts.dao.UserDao;
import com.gifts.entity.User;
import com.gifts.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private CommodityDao commodityDao;

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void save(User user) throws Exception {
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		validator.validate(user);
		userDao.save(user);

	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);

	}

	public void update(User user) {
		userDao.save(user);
	}

	// public void save(User user) {
	// user.setName(user.getName().toUpperCase());
	// if(user.getEmail().contains("@")){
	// userDao.save(user);
	// }else {
	// System.out.println("enter @ sumbol");
	// }
	//
	// }
	//
	// public List<User> findAll() {
	// return userDao.findAll();
	// }
	//
	// public User findOne(int id) {
	// return userDao.findOne(id);
	// }
	//
	// public void delete(int id) {
	// userDao.delete(id);
	//
	// }
	//
	// public void update(User user) {
	// userDao.update(user);
	// }


	@Override
	public User findByName(String name) {
		return userDao.findByLogin(name);
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}


	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return userDao.findByLogin(s);
	}

//	@Override
//	public void like(Principal principal, int commodityId) {
//
//		User user = userDao.findOne(Integer.parseInt(principal.getName()));
//
//		Commodity commodity = commodityDao.findOne(commodityId);
//
//		user.get // this is a first question. I don't have relation with commodities ...
//
//	}


	@Override
	public User findUserWithCommodity(int id) {

		User user = userDao.findUserWithCommodity(id);

		User returnedUser = new User();
		returnedUser.setId(user.getId());
		returnedUser.setLogin(user.getLogin());

		for (int i=0; i < user.getCommodities().size(); i++) {

			returnedUser.getCommodities().add(new Commodity(user.getCommodities().get(i).getId(),
					user.getCommodities().get(i).getName_of_commodity(), user.getCommodities().
					get(i).getPrice_id_uan()));

//			returnedUser.getCommodities().add(new Commodity(user.getCommodities().get(i).getId(),
//			user.getCommodities().get(i).getName_of_commodity(),
//          user.getCommodities().get(i).getRecipe()))
		}

		int counter = 0;
		for (Commodity commodity : user.getCommodities()) {
			returnedUser.getCommodities().get(counter).setMeasuringSystems(commodityDao.
                    findCommoditiesWithMeasuringSystem(commodity.getId()).getMeasuringSystems());
			counter++;
		}

		return returnedUser;

	}

	@Override
	public User findByUuid(String uuid) {
		return userDao.findByUuid(uuid);
	}
}
