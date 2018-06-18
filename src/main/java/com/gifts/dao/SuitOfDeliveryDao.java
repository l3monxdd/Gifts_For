package com.gifts.dao;

import com.gifts.entity.MeasuringSystem;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gifts.entity.SuitOfDelivery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SuitOfDeliveryDao extends JpaRepository<SuitOfDelivery, Integer> {

    SuitOfDelivery findByName (String name);

    @Query("select s from SuitOfDelivery s left join fetch s.orders where s.id =:id")
    SuitOfDelivery findSuitOfDeliveryWithOrders (@Param("id") int id);

}
