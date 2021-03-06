package com.flight.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.dao.BookingDao;
import com.flight.dao.FlightDao;
import com.flight.entity.BookingRecord;
import com.flight.entity.CheckIn;
import com.flight.entity.Flight;
import com.flight.entity.Passenger;
import com.flight.model.FlightSearchQuery;
import com.flight.service.BookingService;


@RestController
@CrossOrigin
@RequestMapping("/api/pss/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	
	@PostMapping("/{id}/{numberofPassengers}")
	public BookingRecord bookFlight(@PathVariable("id") int id,@PathVariable("numberofPassengers")int numberofPassengers, @RequestBody Passenger passenger) {
		return bookingService.bookFlight(id, numberofPassengers, passenger);
	}
	
	//get booking information by bookingID
			@GetMapping("/bookingInformation/{bookingId}")
			public BookingRecord findBybookingId(@PathVariable int bookingId) {
				return bookingService.findBybookingId(bookingId);
			}
			
			// Delete All passengers by Booking Id
			@DeleteMapping("/{bookingId}")
			public void cancelBooking(@PathVariable int bookingId) {
				System.out.println("cancel booking");
				bookingService.cancelBooking(bookingId);
			}

			
			// Delete CoPassengers in booking record
			@DeleteMapping("/remove/{bookingId}")
			public BookingRecord deleteCoPassenger(@PathVariable("bookingId") int bookingId, @RequestBody Passenger passenger) {
				return bookingService.deleteCoPassenger(bookingId, passenger.getCoPassengers());
			}
}
