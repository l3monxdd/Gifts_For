package com.gifts.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String street;
	private String number_of_build;
	private String number_of_apartament;
	private int floor;
	
	@OneToMany(mappedBy="address")
	private List<Orders> orders;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String number_of_build, String number_of_apartament, int floor) {
		super();
		this.street = street;
		this.number_of_build = number_of_build;
		this.number_of_apartament = number_of_apartament;
		this.floor = floor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber_of_build() {
		return number_of_build;
	}

	public void setNumber_of_build(String number_of_build) {
		this.number_of_build = number_of_build;
	}

	public String getNumber_of_apartament() {
		return number_of_apartament;
	}

	public void setNumber_of_apartament(String number_of_apartament) {
		this.number_of_apartament = number_of_apartament;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	
	
	
}
