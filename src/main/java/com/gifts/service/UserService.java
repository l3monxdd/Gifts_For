package com.gifts.service;

import java.security.Principal;
import java.util.List;

import com.gifts.entity.User;

public interface UserService {
	
	void save(User user) throws Exception;
	List<User> findAll();
	User findOne(int id);
	void delete(int id);
	void update(User user);
	User findByName(String name);
	User findByEmail(String email);

//	void like(Principal principal, int commodityId);

	User findUserWithCommodity(int id);

	User findByUuid(String uuid);

	User findUserByLoginWithCommodities(String login);



}
