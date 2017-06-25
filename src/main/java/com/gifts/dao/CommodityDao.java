package com.gifts.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gifts.entity.Commodity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommodityDao extends JpaRepository<Commodity, Integer> {
    @Query("select  i from  Commodity i left join fetch i.measuringSystem")
    List<Commodity> commoditywithMeasuringSystem();

    @Query("select i from  Commodity  i left  join fetch i.measuringSystem where i.id =:id")
    Commodity findCommoditiesWithMeasuringSystem(@Param("id") int id);

    @Query("select i from Commodity i where i.name_of_commodity =:name")
    Commodity findByName_of_commodity (@Param("name") String name);


    @Query(value = "select distinct d from Commodity d left join fetch d.measuringSystem",
            countQuery = "select count(d.id) from Commodity d")
    Page<Commodity> commodityWithMeasuringSystemPages(Pageable pageable);




}
