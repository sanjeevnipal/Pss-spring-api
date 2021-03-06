package com.flight.service;

import java.util.List;


import com.flight.entity.Flight;
import com.flight.model.FlightSearchQuery;

public interface FlightService {
	
	//Find Scheduled flights by Origin,Destination and FlightDate
		List<Flight> findFlights(FlightSearchQuery query);
		
		Flight findFlightByFlightNumberAndOriginAndDestinationAndFlightDate(FlightSearchQuery query);

		Flight findFlightById(int id);
}
