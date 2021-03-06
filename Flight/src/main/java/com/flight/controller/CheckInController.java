package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.entity.BookingRecord;
import com.flight.entity.CheckIn;
import com.flight.entity.Passenger;
import com.flight.service.CheckInService;

@RestController
@CrossOrigin
@RequestMapping("/api/pss/checkin")
public class CheckInController {
	
	@Autowired
	CheckInService checkInService;
	
	@PostMapping("/{id}")
	public CheckIn checkInFlight(@PathVariable("id") int id) {
		return checkInService.checkInFlight(id);
	}
	
	//get Check-In information by bookingID
		@GetMapping("/bookingInfo/{bookingId}")
		public CheckIn findBybsookingRecord_bookingId(@PathVariable int bookingId) {
			return checkInService.findBybookingRecord_bookingId(bookingId);
		}

}
