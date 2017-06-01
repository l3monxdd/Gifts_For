package com.gifts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gifts.entity.Address;

public interface AddressDao extends JpaRepository<Address, Integer> {
    Address findByStreet(String street);

}
