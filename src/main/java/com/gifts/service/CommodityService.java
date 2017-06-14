package com.gifts.service;

import java.util.List;

import com.gifts.entity.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface CommodityService {
	void save(Commodity commodity, int idMS) throws Exception;

	List<Commodity> findAll();

	Page<Commodity> findAll(Pageable pageable);
	Page<Commodity> commodityWithMeasuringSystemPages(Pageable pageable);

	Commodity findOne(int id);

	void delete(int id);

	void update(Commodity commodity);

	List<Commodity> commoditywithMeasuringSystem();

	Commodity findCommoditiesWithMeasuringSystem(int id);

	Commodity findByName_of_commodity (String name_of_commodity);

}
