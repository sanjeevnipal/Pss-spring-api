package com.flight.service;

import java.util.List;

import com.flight.entity.BookingRecord;
import com.flight.entity.CoPassenger;
import com.flight.entity.Passenger;

public interface BookingService {
	
	BookingRecord bookFlight(int id, int numberOfPassengers, Passenger passenger);
	
	BookingRecord findBybookingId(int bookingId);
	
	public void cancelBooking(int bookingId);
	
	BookingRecord getBookingData(int id);
	
	public BookingRecord deleteCoPassenger(int bookingId, List<CoPassenger> coPassengers);

}
