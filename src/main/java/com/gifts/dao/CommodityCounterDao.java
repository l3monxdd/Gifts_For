package com.gifts.dao;

import com.gifts.entity.CommodityCounter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dell on 06.07.17.
 */
public interface CommodityCounterDao extends JpaRepository<CommodityCounter, Integer> {
}
