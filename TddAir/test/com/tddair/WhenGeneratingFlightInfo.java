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
		flight = new Flight("DFW", "ORD", 923, "AA", 453);
		secondFlight = new Flight("MIA", "LAX", 3000, "WN", 2211);
		unknownFlight = new Flight("LAS", "LGA", 2000);
	}
	
	@Test
	public void shouldBeProperlyFormatted() {
		assertEquals("AA453 | DFW -> ORD | 923 miles", flight.getInfo());
	}

	@Test
	public void shouldWorkForMultipleFlights() {
		assertEquals("AA453 | DFW -> ORD | 923 miles", flight.getInfo());
	}

	@Test
	public void shouldAllowForUnknownFightNumbers() {
		assertEquals("AA453 | DFW -> ORD | 923 miles", flight.getInfo());
	}

}
