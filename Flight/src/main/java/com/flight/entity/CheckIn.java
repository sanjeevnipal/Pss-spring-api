package com.flight.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CheckIn {

	@Id
	@GeneratedValue
	private int checkinId;
	private LocalDateTime checkinTime;
	private String seatNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookingId")
	private BookingRecord bookingRecord;
	
	
	public CheckIn() {}
	
	public CheckIn(LocalDateTime checkinTime, String seatNumber, BookingRecord bookingRecord) {
		super();
		this.checkinTime = checkinTime;
		this.seatNumber = seatNumber;
		this.bookingRecord = bookingRecord;
	}
	public BookingRecord getBookingRecord() {
		return bookingRecord;
	}
	public void setBookingRecord(BookingRecord bookingRecord) {
		this.bookingRecord = bookingRecord;
	}
	public int getCheckinId() {
		return checkinId;
	}
	public void setCheckinId(int checkinId) {
		this.checkinId = checkinId;
	}
	public LocalDateTime getCheckinTime() {
		return checkinTime;
	}
	public void setCheckinTime(LocalDateTime checkinTime) {
		this.checkinTime = checkinTime;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
}
