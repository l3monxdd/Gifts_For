package com.gifts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gifts.entity.MeasuringSystem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MeasuringSystemDao extends JpaRepository<MeasuringSystem, Integer> {

    MeasuringSystem findByName(String name);

    @Query("select  m from MeasuringSystem m left join fetch m.commodities where m.id =:id")
    MeasuringSystem findCommodityWithMeasuringSystem(@Param("id") int id);


}
