package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenGeneratingFlightInfo {

	private Flight flight1;
	private Flight secondFlight;
	private Flight unknownFlight;
	
	@Before
	public void setup(){
		flight1 = new Flight( "DFW", "ORD", 923, "AA", 453);
		secondFlight = new Flight("MIA", "LAX", 3000, "WN", 2311);
		unknownFlight = new Flight ("LAS", "LGA", 2000);
	}
	@Test
	public void shouldBeProperlyFormatted() {
		assertEquals("AA453 | DFW -> ORD | 923 miles", flight1.getInfo());
	}
	@Test
	public void shouldWorkForMultipleFlights() {
		assertEquals("WN2311 | MIA -> LAX | 3000 miles", secondFlight.getInfo());
	}	@Test
	public void shouldAllowForUnkownFlightNumbers() {
		assertEquals("UNKNOWN | LAS -> LGA | 2000 miles", unknownFlight.getInfo());
	}
}
