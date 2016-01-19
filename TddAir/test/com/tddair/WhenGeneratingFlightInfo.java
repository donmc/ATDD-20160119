package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenGeneratingFlightInfo {

	private Flight flight, secondFlight, unknownFlight;
	
	@Before
	public void setup() {
		
		flight = new Flight("MIA", "LAX", 3000, "WN", 2311);
		secondFlight =  new Flight("DFW", "ORD", 920, "AA", 453);
		unknownFlight =  new Flight("DFW", "SAN", 4000);
	}
	
	@Test
	public void shouldBeProperlyFormatted() {
		assertEquals("AA453 | DFW -> ORD | 920", secondFlight.getInfo());
	}
	
	@Test
	public void shouldWorkforMultipleFlight() {
		assertEquals("WN2311 | MIA -> LAX | 3000", flight.getInfo());
	}
	
	@Test
	public void shouldReturnUnknownForUnknownFlightNumber() {
		assertEquals("UNKNOWN | DFW -> SAN | 4000", unknownFlight.getInfo());
	}
}
