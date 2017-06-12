package com.gifts.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Commodity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name_of_commodity;
	private int counter; // - кількість одиниць товару в замовленні
	private int quantity; // кількість на складі
	private double price_id_uan;

	@ManyToMany
	@JoinTable(name = "orders_commodity",
			joinColumns = @JoinColumn(name = "commodity_id"),
			inverseJoinColumns = @JoinColumn(name = "orders_id"))
	private List<Orders> orders;

	@ManyToMany
	@JoinTable(name = "commodity_measuring_system",
			joinColumns = @JoinColumn(name = "commodity_id"),
			inverseJoinColumns = @JoinColumn(name = "measuring_system_id"))
	private List<MeasuringSystem> measuringSystems = new ArrayList<MeasuringSystem>();

	@ManyToMany
	@JoinTable(name = "user_commodity",
			joinColumns = @JoinColumn(name = "commodity_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users = new ArrayList<User>();

	public Commodity() {
		// TODO Auto-generated constructor stub
	}


	public Commodity(int id, String name_of_commodity, double price_id_uan) {
		super();
		this.id = id;
		this.name_of_commodity = name_of_commodity;
		this.price_id_uan = price_id_uan;

	}



	public Commodity(String name_of_commodity) {
		this.name_of_commodity = name_of_commodity;
	}






	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName_of_commodity() {
		return name_of_commodity;
	}

	public void setName_of_commodity(String name_of_commodity) {
		this.name_of_commodity = name_of_commodity;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public double getPrice_id_uan() {
		return price_id_uan;
	}

	public void setPrice_id_uan(double price_id_uan) {
		this.price_id_uan = price_id_uan;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


	public List<MeasuringSystem> getMeasuringSystems() {
		return measuringSystems;
	}

	public void setMeasuringSystems(List<MeasuringSystem> measuringSystems) {
		this.measuringSystems = measuringSystems;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Commodity{" +
				"name_of_commodity='" + name_of_commodity + '\'' +
				", price_id_uan=" + price_id_uan +
				'}';
	}
}
