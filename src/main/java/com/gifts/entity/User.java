package com.gifts.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
	@NamedQuery(name="findAllUsers", query="select u from User u"),
	
	
})


@Entity
/*@Table(name = "customer") - в бд створить назву кастумер але буде працювати з юзером */
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // до кожного наступного обєкту буде додаватися 1 
	private int id;
	
	private String login;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String phone_number;
	private String bonus;
	@OneToMany(mappedBy="user")
	private List<Orders> orders;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String login, String firstname, String lastname, String email, String password, String phone_number) {
		this.login = login;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
}
