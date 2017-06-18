package com.gifts.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.gifts.validator.Validator;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gifts.dao.SuitOfDeliveryDao;
import com.gifts.entity.SuitOfDelivery;
import com.gifts.service.SuitOfDeliveryService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SuitOfDeliveryServiceImpl implements SuitOfDeliveryService {


	@Autowired
	private SuitOfDeliveryDao suitOfDeliveryDao;

	@Autowired
	@Qualifier("suitOfDeliveryValidator")
	private Validator validator;

	public void save(SuitOfDelivery suitOfDelivery, MultipartFile image) throws Exception {
		validator.validate(suitOfDelivery);
		suitOfDeliveryDao.saveAndFlush(suitOfDelivery);

		String path = System.getProperty("catalina.home") + "/resources/"
				+ suitOfDelivery.getName() + "/" + image.getOriginalFilename();

		suitOfDelivery.setPathImage("resources/" + suitOfDelivery.getName() + "/" +image.getOriginalFilename());

		File filePath = new File(path);

		try {
			filePath.mkdirs();
			try {
				FileUtils.cleanDirectory
						(new File(System.getProperty("catalina.home")+ "/resources/"+ suitOfDelivery.getName() + "/"));
			}catch (IOException e) {
				e.printStackTrace();
			}
			image.transferTo(filePath);
		} catch (IOException e) {
			System.out.println("error with file");
		}

		suitOfDeliveryDao.save(suitOfDelivery);
	}

	public List<SuitOfDelivery> findAll() {
		return suitOfDeliveryDao.findAll();
	}

	public SuitOfDelivery findOne(int id) {
		return suitOfDeliveryDao.findOne(id);
	}

	public void delete(int id) {
		suitOfDeliveryDao.delete(id);
	}

	public void update(SuitOfDelivery suitOfDelivery, MultipartFile image) {


		suitOfDelivery.setName(suitOfDelivery.getName());

		String path = System.getProperty("catalina.home") + "/resources/"
				+ suitOfDelivery.getName() + "/" + image.getOriginalFilename();

		suitOfDelivery.setPathImage("resources/" + suitOfDelivery.getName() + "/" +image.getOriginalFilename());

		File filePath = new File(path);

		try {
			filePath.mkdirs();
			image.transferTo(filePath);
		} catch (IOException e) {
			System.out.println("error with file");
		}

		suitOfDeliveryDao.save(suitOfDelivery);
	}

//	@Override
//	public SuitOfDelivery findByName_of_suit(String name_of_suit) {
//		return suitOfDeliveryDao.findByName_of_suit(name_of_suit);
//	}

	@Override
	public SuitOfDelivery findByName(String name) {

		return suitOfDeliveryDao.findByName(name);
	}
}
