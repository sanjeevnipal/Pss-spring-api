package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entity.Passenger;

public interface PassengerDao extends JpaRepository<Passenger, Integer> {

}
