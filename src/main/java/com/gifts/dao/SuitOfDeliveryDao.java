package com.gifts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gifts.entity.SuitOfDelivery;

public interface SuitOfDeliveryDao extends JpaRepository<SuitOfDelivery, Integer> {

    SuitOfDelivery findByName (String name);

}
