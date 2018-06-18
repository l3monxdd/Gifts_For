package com.gifts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gifts.entity.User;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {

	// @Query("select u from User u where u.name=:param1 and u.email=:param2")
	// User findUserByNameEmail(@Param("param1") String name, @Param("param2")
	// String email);

	User findByLoginAndEmail(String name, String email); // описуэ даний клас по
														// критеріям пошуку
														// (стрінг - нейм, мейл)
	// головне правильно написати, тоді спрінг задасть критерії пошуку сам, по
	// прикладу методу findUserByNameEmail

	@Query("select u from User u left join fetch u.orders where u.id=:id")
	User findUserWithOrders(int id);// знаходимо всі замовлення юзера по id

	@Query("select  u from  User u left  join  fetch  u.commodities where u.login =:login")
	User findUserByLoginWithCommodities(@Param("login") String login);




	User findByLogin(String name);

	User findByEmail(String email);

	@Query("select u from User u left join fetch u.commodities where u.id=:id")
	User findUserWithCommodity(@Param("id") int id);


	@Query("select  u from  User u where  u.uuid =:uuid")
	User findByUuid(@Param("uuid") String uuid);
}
