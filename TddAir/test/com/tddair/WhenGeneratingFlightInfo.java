package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenGeneratingFlightInfo {

	private Flight flight;
	private Flight secondFlight;
	private Flight unknownFlight;
	
	@Before
	public void setup() {
		flight = new Flight("DFW", "ORD", 920, "AA", 453);
		secondFlight = new Flight("MIA", "LAX", 3000, "DL", 122);
		unknownFlight = new Flight("DFW", "ORD", 920);
	}
	
	@Test
	public void shouldBeProperlyFormatted() {
		assertEquals("AA453 | DFW -> ORD | 920 miles", flight.getInfo());
	}

	@Test
	public void shouldWorkForMultipleFlights() {
		assertEquals("DL122 | MIA -> LAX | 3000 miles", secondFlight.getInfo());
	}
	
	@Test
	public void shouldAllowForUnknown() {
		assertEquals("UNKNOWN | DFW -> ORD | 920 miles", unknownFlight.getInfo());
	}
}
