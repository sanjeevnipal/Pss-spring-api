package com.flight.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.flight.entity.Flight;

import com.flight.dao.FlightDao;
import com.flight.model.FlightSearchQuery;

@Service
public class FlightImplementationService implements FlightService{

	@Autowired
	private FlightDao flightDao;
	
	//Find Scheduled flights by Origin,Destination and FlightDate
		@Override
		public List<Flight> findFlights(FlightSearchQuery query) {

			List<Flight> flights = flightDao.findFlightByOriginAndDestinationAndFlightDate(query.getOrigin(),
					query.getDestination(), query.getFlightDate());

			flights = flights.stream().filter(flight -> flight.getInventory().getCount() >= query.getTravellers())
					.collect(Collectors.toList());

			return flights;

		}
		
		@Override
		public Flight findFlightByFlightNumberAndOriginAndDestinationAndFlightDate(FlightSearchQuery query) {
			System.out.println("sanjeevni");
			return flightDao.findByFlightNumberAndOriginAndDestinationAndFlightDate(query.getFlightNumber(),
					query.getOrigin(), query.getDestination(), query.getFlightDate());
		}
		
		//Find Flight By Flight Schedule ID
		@Override
		public Flight findFlightById(int id) {
			System.out.println("sanjeevni pal");
			return flightDao.findById(id).orElse(null);
		}
		
		
}
