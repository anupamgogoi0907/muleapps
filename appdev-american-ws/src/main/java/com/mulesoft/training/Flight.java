package com.mulesoft.training;

import java.util.Comparator;

public class Flight implements java.io.Serializable, Comparable<Flight> {
	
	String flightCode;
	String origination;
	int availableSeats;
	String departureDate;
	String airlineName;
	String destination;
	double price;
	String planeType;

	public Flight()	{

	}

	public Flight(String flightCode, String destination, double price, String planeType) {
		this.flightCode = flightCode;
		this.destination = destination;
		this.price = price;
		this.planeType = planeType;
	}

	public Flight(String flightCode, String airlineName, String destination,
			String origination, String departureDate, double price,
			String planeType, int availableSeats) {
		this.flightCode = flightCode;
		this.airlineName = airlineName;
		this.destination = destination;
		this.origination = origination;
		this.departureDate = departureDate;
		this.price = price;
		this.planeType = planeType;
		this.availableSeats = availableSeats;
	}

	public Flight(String flightCode, String airlineName, String destination,
			String origination, String departureDate, double price,
			String planeType) {
		this.flightCode = flightCode;
		this.airlineName = airlineName;
		this.destination = destination;
		this.origination = origination;
		this.departureDate = departureDate;
		this.price = price;
		this.planeType = planeType;
	}

	public Flight(String flightCode, String airlineName, String destination,
			String origination, String departureDate, double price,
			int availableSeats) {
		this.flightCode = flightCode;
		this.airlineName = airlineName;
		this.destination = destination;
		this.origination = origination;
		this.departureDate = departureDate;
		this.price = price;
		this.availableSeats = availableSeats;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOrigination() {
		return origination;
	}

	public void setOrigination(String origination) {
		this.origination = origination;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPlaneType() {
		return planeType;
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	@Override
	public int compareTo(Flight otherFlight) {
		int value = Double.compare(this.getPrice(), otherFlight.getPrice());
		return value;
	}

};
