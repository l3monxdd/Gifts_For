package com.gifts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gifts.entity.Orders;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersDao extends JpaRepository<Orders, Integer> {

    @Query("select o from Orders o left  join  fetch o.commodities")
    List<Orders> ordersWithCommodities();

    // distinct - вивести неповторювальні елементи
    @Query("select distinct o from  Orders o left  join fetch  o.commodityCounters")
    List<Orders> ordersWithCommodityCounters();

}
