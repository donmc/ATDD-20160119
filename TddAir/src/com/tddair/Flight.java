package com.tddair;


public class Flight {
	
	private static final String DELIMETER = "|";
	private String origin;
	private String destination;
	private String airline;
	private int number;
	private int mileage;

	public Flight(String origin, String destination, int mileage, String airline, int number) {
		if(origin == null || origin.length() != 3) {
			throw new IllegalArgumentException("Invalid origin code");
		}
		if(destination == null || destination.length() != 3) {
			throw new IllegalArgumentException("Invalid destination code");
		}
		if(mileage < 100) {
			throw new IllegalArgumentException("Mileage must be greater than 100");
		}
		this.origin = origin;
		this.destination = destination;
		this.mileage = mileage;
		this.airline = airline;
		this.number = number;
	}
	
	public Flight(String origin, String destination, int mileage) {
		this(origin, destination, mileage, null, 0);
	}
	
	public String getFullFlightNumber() {

		return (airline == null || number ==0 ) ? "UNKNOWN" : airline+number;
	}
	
	public String getInfo()
	{
		return getFullFlightNumber() + DELIMETER + origin + " -> " + destination + DELIMETER + mileage + " miles";
	}
	
	
	public String getDestination() {
		return destination;
	}
	public String getOrigin() {
		return origin;
	}
	public int getMileage() {
		return mileage;
	}
	
}
