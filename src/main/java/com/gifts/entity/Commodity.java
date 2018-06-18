package com.gifts.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Commodity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name_of_commodity;
	private int counter; // - кількість одиниць товару в замовленні
	private int quantity; // кількість на складі
	private double price_id_uan;

	private String pathImage;

	@OneToMany(mappedBy = "commodity")
	private List<CommodityCounter> commodityCounters = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "orders_commodity",
			joinColumns = @JoinColumn(name = "commodity_id"),
			inverseJoinColumns = @JoinColumn(name = "orders_id"))
	private List<Orders> orders = new ArrayList<>();

	@ManyToOne
	private MeasuringSystem measuringSystem;

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

	public Commodity( String name_of_commodity, int quantity, double price_id_uan) {
		this.name_of_commodity = name_of_commodity;
		this.quantity = quantity;
		this.price_id_uan = price_id_uan;

	}

	public Commodity(int id, String name_of_commodity, int quantity, double price_id_uan) {
		super();
		this.id = id;
		this.name_of_commodity = name_of_commodity;
		this.quantity = quantity;
		this.price_id_uan = price_id_uan;

	}

	public Commodity(String name_of_commodity) {
		this.name_of_commodity = name_of_commodity;
	}


	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
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


	public MeasuringSystem getMeasuringSystem() {
		return measuringSystem;
	}

	public void setMeasuringSystem(MeasuringSystem measuringSystem) {
		this.measuringSystem = measuringSystem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<CommodityCounter> getCommodityCounters() {
		return commodityCounters;
	}

	public void setCommodityCounters(List<CommodityCounter> commodityCounters) {
		this.commodityCounters = commodityCounters;
	}

	@Override
	public String toString() {
		return "Commodity{" +
				"name_of_commodity='" + name_of_commodity + '\'' +
				", price_id_uan=" + price_id_uan +
				'}';
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Commodity commodity = (Commodity) o;

		return id == commodity.id;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
