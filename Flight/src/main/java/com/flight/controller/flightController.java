package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import com.flight.service.FlightService;
import com.flight.dao.BookingDao;
import com.flight.dao.FlightDao;
import com.flight.entity.BookingRecord;
import com.flight.entity.Flight;
import com.flight.entity.Passenger;
import com.flight.model.FlightSearchQuery;


@RestController
@CrossOrigin
@RequestMapping("/api/pss/search")
public class flightController {
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private FlightDao dao;

	@Autowired
	private BookingDao bookingDao;
	
	// find flights
		@PostMapping
		public List<Flight> findFlights(@RequestBody FlightSearchQuery query){

			return flightService.findFlights(query);
		}
		
		// find a single flight
		@PostMapping("/byFlightNumber")
		public Flight findFlightById(@RequestBody FlightSearchQuery query) {
			return flightService.findFlightByFlightNumberAndOriginAndDestinationAndFlightDate(query);
		}
		
		@GetMapping("/{flightId}")
		public Flight findById(@PathVariable int flightId) {
			return flightService.findFlightById(flightId);
		}
		
		

}
