package com.flight.model;

import java.time.LocalDate;
import java.util.List;

import com.flight.entity.CoPassenger;
import com.flight.entity.Passenger;

public class FlightSearchQuery {
	
	private String origin;
	private String destination;
	private String flightNumber;
	private LocalDate flightDate;
	private int travellers;
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public LocalDate getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}
	public int getTravellers() {
		return travellers;
	}
	public void setTravellers(int travellers) {
		this.travellers = travellers;
	}

}
