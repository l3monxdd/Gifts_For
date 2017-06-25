package com.gifts.entity;

import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Type(type = "text")
	private String description;
	private LocalDate date;
	
	@ManyToOne
	private User user;
	
	@ManyToMany
	@JoinTable(name="orders_commodity",
	joinColumns=@JoinColumn(name="orders_id"),
	inverseJoinColumns=@JoinColumn(name="commodity_id"))
	private List<Commodity> commodities = new ArrayList<>();
	
	@ManyToOne
	private Address address;
	
	@ManyToOne
	private SuitOfDelivery delivery;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(LocalDate date) {
		this.date = date;
	}

	public Orders(String description, LocalDate date) {
		super();
		this.description = description;
		this.date = date;
	}






	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<Commodity> getCommodities() {
		return commodities;
	}



	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public SuitOfDelivery getDelivery() {
		return delivery;
	}



	public void setDelivery(SuitOfDelivery delivery) {
		this.delivery = delivery;
	}



	
	
	
	

}
