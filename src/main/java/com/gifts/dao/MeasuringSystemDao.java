package com.gifts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gifts.entity.MeasuringSystem;

public interface MeasuringSystemDao extends JpaRepository<MeasuringSystem, Integer> {

    MeasuringSystem findByName(String name);

}
