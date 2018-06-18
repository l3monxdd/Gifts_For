package com.gifts.service;

import java.util.List;

import com.gifts.entity.MeasuringSystem;

public interface MeasuringSystemService {

	void save(MeasuringSystem measuringSystem) throws Exception;

	List<MeasuringSystem> findAll();

	MeasuringSystem findOne(int id);

	void delete(int id);

	void update(MeasuringSystem measuringSystem);

	MeasuringSystem findByName(String name);

}
