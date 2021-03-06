package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entity.BookingRecord;
import com.flight.entity.CheckIn;

public interface BookingDao extends JpaRepository<BookingRecord, Integer>{

	BookingRecord findBybookingId(int bookingId);
}
