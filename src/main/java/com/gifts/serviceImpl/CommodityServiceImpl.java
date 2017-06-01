package com.gifts.serviceImpl;

import java.util.List;

import com.gifts.dao.MeasuringSystemDao;
import com.gifts.entity.MeasuringSystem;
import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gifts.dao.CommodityDao;
import com.gifts.entity.Commodity;
import com.gifts.service.CommodityService;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;

	@Autowired
	@Qualifier("commodityValidator")
	private Validator validator;

	@Autowired
	private MeasuringSystemDao measuringSystemDao;

	public void save(Commodity commodity, int idMS) throws Exception {
		MeasuringSystem measuringSystem = measuringSystemDao.findOne(idMS);

		commodityDao.saveAndFlush(commodity);

		commodity.getMeasuringSystems().add(measuringSystem);

		validator.validate(commodity);
		commodityDao.save(commodity);

	}

	public List<Commodity> findAll() {
		return commodityDao.findAll();
	}

	public Commodity findOne(int id) {
		return commodityDao.findOne(id);
	}

	public void delete(int id) {
		commodityDao.delete(id);
	}

	public void update(Commodity commodity) {
		commodityDao.save(commodity);
	}

	@Override
	public List<Commodity> commoditywithMeasuringSystem() {
		return commodityDao.commoditywithMeasuringSystem();
	}

	@Override
	public Commodity findCommoditiesWithMeasuringSystem(int id) {
		return commodityDao.findCommoditiesWithMeasuringSystem(id);
	}

	@Override
	public Commodity findByName_of_commodity(String name_of_commodity) {
		return commodityDao.findByName_of_commodity(name_of_commodity);
	}
}
