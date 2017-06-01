package com.gifts.serviceImpl;

import java.util.List;

import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gifts.dao.MeasuringSystemDao;
import com.gifts.entity.MeasuringSystem;
import com.gifts.service.MeasuringSystemService;

@Service
public class MeasuringSystemServiceImpl implements MeasuringSystemService {

	@Autowired
	private MeasuringSystemDao measuringSystemDao;

	@Autowired
	@Qualifier("measuringSystemValidator")
	private Validator validator;

	public void save(MeasuringSystem measuringSystem) throws Exception {
		validator.validate(measuringSystem);
		measuringSystemDao.save(measuringSystem);
	}

	public List<MeasuringSystem> findAll() {
		return measuringSystemDao.findAll();
	}

	public MeasuringSystem findOne(int id) {
		return measuringSystemDao.findOne(id);
	}

	public void delete(int id) {
		measuringSystemDao.delete(id);
	}

	public void update(MeasuringSystem measuringSystem) {
		measuringSystemDao.save(measuringSystem);
	}

	@Override
	public MeasuringSystem findByName(String name) {
		return measuringSystemDao.findByName(name);
	}
}
