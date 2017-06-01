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

	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "commodity_measuring_system", joinColumns = @JoinColumn(name = "measuring_system_id"), inverseJoinColumns = @JoinColumn(name = "commodity_id"))
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
}
