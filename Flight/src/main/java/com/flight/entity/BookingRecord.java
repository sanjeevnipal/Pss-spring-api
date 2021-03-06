package com.flight.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BookingRecord {
	
	@Id
	@GeneratedValue
	private int bookingId;
	private String origin;
	private String destination;
	private LocalDateTime bookingDate;
	private double fare;
	private LocalDate flightDate;
	private LocalTime flightTime;
	private String status;
	private String flightNumber;

	@OneToOne
	@JoinColumn(name = "flightInfoid")
	private FlightInfo flightInfo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passengerId")
	private Passenger passenger;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
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
	public LocalDateTime getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public LocalDate getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}
	public LocalTime getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public FlightInfo getFlightInfo() {
		return flightInfo;
	}
	public void setFlightInfo(FlightInfo flightInfo) {
		this.flightInfo = flightInfo;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	
	public BookingRecord() {}
	public BookingRecord(String origin, String destination, LocalDateTime bookingDate, double fare,
			LocalDate flightDate, LocalTime flightTime, String status, String flightNumber, FlightInfo flightInfo,
			Passenger passenger) {
		super();
//		this.bookingId = bookingId;
		this.origin = origin;
		this.destination = destination;
		this.bookingDate = bookingDate;
		this.fare = fare;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.status = status;
		this.flightNumber = flightNumber;
		this.flightInfo = flightInfo;
		this.passenger = passenger;
	}
	
}
