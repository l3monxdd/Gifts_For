package com.gifts.serviceImpl;

import java.util.List;

import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gifts.dao.UserDao;
import com.gifts.entity.User;
import com.gifts.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	public void save(User user) throws Exception {
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
}
