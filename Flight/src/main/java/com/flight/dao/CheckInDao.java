package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entity.CheckIn;



public interface CheckInDao extends JpaRepository<CheckIn, Integer> {

	CheckIn findBybookingRecord_bookingId(int bookingId);
}
