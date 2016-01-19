package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WhenGeneratingFlightInfo {

	private Flight flight, secondFlight, unknownFlight;

	@Before
	public void setup() {
		flight = new Flight("DFW", "ORD", 923, "AA", 453);
		secondFlight = new Flight("DFW", "LAX", 3000, "AA", 453);
		unknownFlight = new Flight("DFW", "ORD", 923, null, 453);
	}

	@Test
	public void shouldBeProperlyFormatted() {
		assertEquals("AA453 | DFW -> ORD | 923 miles", flight.getInfo());
	}

	@Test
	public void shouldWorkForMultipleFlights() {
		assertEquals("AA453 | DFW -> LAX | 3000 miles", secondFlight.getInfo());
	}

	@Test
	public void shouldAllowForUnknownFlightNumber() {
		assertEquals("UNKNOWN | DFW -> ORD | 923 miles", unknownFlight.getInfo());
	}
}
