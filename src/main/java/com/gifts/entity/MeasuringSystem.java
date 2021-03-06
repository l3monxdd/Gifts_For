package com.gifts.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class MeasuringSystem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@OneToMany(mappedBy = "measuringSystem")
	private List<Commodity> commodities = new ArrayList<Commodity>();

	public MeasuringSystem() {
		// TODO Auto-generated constructor stub
	}

	public MeasuringSystem(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}



	@Override
	public String toString() {
		return "MeasuringSystem{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
