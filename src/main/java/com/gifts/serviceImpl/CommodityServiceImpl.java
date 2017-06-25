package com.gifts.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gifts.dao.MeasuringSystemDao;
import com.gifts.entity.MeasuringSystem;
import com.gifts.validator.Validator;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gifts.dao.CommodityDao;
import com.gifts.entity.Commodity;
import com.gifts.service.CommodityService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;

	@Autowired
	@Qualifier("commodityValidator")
	private Validator validator;

	@Autowired
	private MeasuringSystemDao measuringSystemDao;

	public void save(Commodity commodity, int idMS, MultipartFile image) throws Exception {
		validator.validate(commodity);

		MeasuringSystem measuringSystem = measuringSystemDao.findOne(idMS);

		commodityDao.saveAndFlush(commodity);

		commodity.setMeasuringSystem(measuringSystem);

//		String path = System.getProperty("catalina.home") + "/resources/"
//				+ commodity.getName_of_commodity() + "/" + image.getOriginalFilename();
//
//		commodity.setPathImage("resourcmeasuringSystemses/" + commodity.getName_of_commodity() + "/" +image.getOriginalFilename());
//
		String path = System.getProperty("catalina.home") + "/resources/"
				+ commodity.getName_of_commodity() + "/" + image.getOriginalFilename();

		commodity.setPathImage("resources/" + commodity.getName_of_commodity() + "/" + image.getOriginalFilename());


		File filePath = new File(path);

		try {
			filePath.mkdirs();
			image.transferTo(filePath);
		} catch (IOException e) {
			System.out.println("error with file");
		}


//		File filePath = new File(path);
//
//		try {
//			filePath.mkdirs();
//			image.transferTo(filePath);
//			try {
//				FileUtils.cleanDirectory
//						(new File(System.getProperty("catalina.home")+ "/resources/"
//								+ commodity.getName_of_commodity() + "/"));
//			}catch (IOException e) {
//				e.printStackTrace();
//			}
////			image.transferTo(filePath);
//		} catch (IOException e) {
//			System.out.println("error with file");
//		}

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

	@Override
	public Page<Commodity> findAll(Pageable pageable) {
		return commodityDao.findAll(pageable);
	}

	@Override
	public Page<Commodity> commodityWithMeasuringSystemPages(Pageable pageable) {
		return commodityDao.commodityWithMeasuringSystemPages(pageable);
	}

	@Override
	public void update(Commodity commodity, MultipartFile image, int measuringSystems) {

		String path = System.getProperty("catalina.home") + "/resources/"
				+ commodity.getName_of_commodity() + "/" + image.getOriginalFilename();

		commodity.setPathImage("resources/" + commodity.getName_of_commodity() + "/" + image.getOriginalFilename());

		File filePath = new File(path);

		try {
			filePath.mkdirs();
			image.transferTo(filePath);
		} catch (IOException e) {
			System.out.println("error with file");
		}

		MeasuringSystem measuringSystem = measuringSystemDao.findOne(measuringSystems);

		commodity.setMeasuringSystem(measuringSystem);

		commodityDao.save(commodity);

	}
}
