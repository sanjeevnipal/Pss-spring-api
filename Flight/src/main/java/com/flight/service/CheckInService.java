package com.flight.service;

import com.flight.entity.CheckIn;

public interface CheckInService {

	CheckIn checkInFlight(int id);
	
	CheckIn findBybookingRecord_bookingId(int bookingId);
}
