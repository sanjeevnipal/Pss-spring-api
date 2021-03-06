package com.flight.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.BookingDao;
import com.flight.dao.CheckInDao;
import com.flight.entity.BookingRecord;
import com.flight.entity.CheckIn;
import com.flight.entity.Flight;

@Service
public class CheckInImplService implements CheckInService {
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private CheckInDao checkinDao;
	
	@Override
	public CheckIn checkInFlight(int id) {
		BookingRecord bookingRecord = bookingDao.findById(id).orElse(null);
		if (bookingRecord != null) {
		
		CheckIn checkIn = new CheckIn(LocalDateTime.now(), "A5", bookingRecord);
				checkinDao.save(checkIn);
				bookingRecord.setStatus("CHECKED-IN");
				bookingDao.save(bookingRecord);
				
				return checkIn;
		}
		return null;
				
	}
	
	@Override
	public CheckIn findBybookingRecord_bookingId(int bookingId) {
		return checkinDao.findBybookingRecord_bookingId(bookingId);
	}
	
	

}
