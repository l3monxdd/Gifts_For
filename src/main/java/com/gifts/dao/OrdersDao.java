package com.gifts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gifts.entity.Orders;

public interface OrdersDao extends JpaRepository<Orders, Integer> {

}
