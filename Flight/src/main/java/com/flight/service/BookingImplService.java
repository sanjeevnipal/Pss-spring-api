package com.flight.service;

import java.io.Console;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.flight.dao.BookingDao;
import com.flight.dao.CoPassengerDao;
import com.flight.dao.FlightDao;
import com.flight.dao.InventoryDao;
import com.flight.entity.BookingRecord;
import com.flight.entity.CheckIn;
import com.flight.entity.CoPassenger;
import com.flight.entity.Fare;
import com.flight.entity.Flight;
import com.flight.entity.Inventory;
import com.flight.entity.Passenger;

@Service
public class BookingImplService implements BookingService {
	
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private InventoryDao inventoryDao;
	
	@Autowired
	private CoPassengerDao coPassengerDao;
	
	@Autowired
	private FlightService flightService;

	 @Override
	    public BookingRecord bookFlight(int id,int numberOfPassengers, Passenger passenger) {
	     System.out.println("submit form");
		 Flight flight = flightDao.findById(id).orElse(null);
	     Fare fare = flight.getFare();
	     
	     if(flight.getInventory().getCount() < numberOfPassengers) {
	         System.out.print("seats not available");
	     }
	     else {
	    	 int passengerCount = passenger.getCoPassengers().size()+1;
	         BookingRecord bookingRecord = new BookingRecord(flight.getOrigin(), flight.getDestination(),
	                 LocalDateTime.now(),  fare.getFare()*passengerCount, flight.getFlightDate(), flight.getFlightTime(),
	                 "CONFIRMED",flight.getFlightNumber(),flight.getFlightInfo(), passenger);
	         bookingDao.save(bookingRecord); 
	         Inventory inventory = flight.getInventory();
	         inventory.setCount(inventory.getCount() - numberOfPassengers);
	         inventoryDao.save(inventory);
	         return bookingRecord;
	         
	     }
	        return null;
	    
	    }
	 
	 // Find booking record by booking id
	 @Override
		public BookingRecord findBybookingId(int bookingId) {
			return bookingDao.findBybookingId(bookingId);
		}
	 
	// Cancel All the passengers
		@Override
		public void cancelBooking(int bookingId) {
			System.out.println("cancel booking in dao");
			bookingDao.deleteById(bookingId);	
		}
		
		@Override
		public BookingRecord getBookingData(int id) {
			return bookingDao.findById(id).orElse(null);
		}
		
		// Cancel booking for selected CO-Passengers only
		 @Override
	    public BookingRecord deleteCoPassenger(int bookingId, List<CoPassenger> coPassengers) {
	        BookingRecord booking = bookingDao.findBybookingId(bookingId);
	        Flight flight = flightDao.findByFlightInfo_flightInfoid(booking.getFlightInfo().getFlightInfoid());
	        for(CoPassenger cp : coPassengers) {
	        	coPassengerDao.deleteCopassengersById(cp.getCopassengerId());
//	        	coPassengerDao.deleteByCopassengerId(cp.getCopassengerId());
	        	
	        }
	        Inventory inventory = flight.getInventory();
	        inventory.setCount(inventory.getCount() + coPassengers.size());
	        inventoryDao.save(inventory);

	        bookingDao.save(booking);
	        return booking;
	    }
}
