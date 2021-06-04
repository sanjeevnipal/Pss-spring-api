package com.flight.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entity.Flight;
import com.flight.entity.FlightInfo;


public interface FlightDao extends JpaRepository<Flight, Integer>{
	
	List<Flight> findFlightByOriginAndDestinationAndFlightDate(String origin,String destination,LocalDate flightDate);
	
	Flight findByFlightNumberAndOriginAndDestinationAndFlightDate(String flightNumber,String origin,String destination,LocalDate flightDate);
	
	Flight findByFlightInfo_flightInfoid(int id);
}
