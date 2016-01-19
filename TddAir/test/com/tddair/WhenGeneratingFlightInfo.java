package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenGeneratingFlightInfo {

	private Flight firstFlight, secondFlight, unknownFlightNoAirline, unknownFlightNoFlightNbr;
	
	@Before
	public void setup()
	{
		firstFlight = new Flight("DFW", "ATX", 150, "NW", 333);
		secondFlight = new Flight("DFW", "LAX", 1500, "NW", 333);
		unknownFlightNoAirline = new Flight("DFW", "ATX", 150, null , 333);
		unknownFlightNoFlightNbr = new Flight("DFW", "ATX", 150, "NW" , 0);
	}
	
	@Test
	public void shouldBeProperlyFormatted() {
		assertEquals("NW333|DFW -> ATX|150 miles", firstFlight.getInfo());
	}
	
	@Test
	public void shouldWorkForMultipleFlights() {
		assertEquals("NW333|DFW -> LAX|1500 miles", secondFlight.getInfo());
	}
	
	@Test
	public void shouldAllowForUnknownFlightNumber() {
		assertEquals("UNKNOWN|DFW -> ATX|150 miles", unknownFlightNoAirline.getInfo());
	}
	
	@Test
	public void shouldAllowForUnknownAirline() {
		assertEquals("UNKNOWN|DFW -> ATX|150 miles", unknownFlightNoFlightNbr.getInfo());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldNotAllowLowMileage()
	{
		new Flight("DFW", "ATX", 10, "NW" , 111);
	}
	

}
