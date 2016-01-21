package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
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
	public void shouldThrowWhenOriginMissing() {
		Flight badOriginFlight;
		try {
			badOriginFlight = new Flight(null, "LGA", 2000);
			Assert.fail();
		}
		catch(IllegalArgumentException e) {
			assertEquals("Invalid origin code", e.getMessage());
		}
	}
	
	@Test
	public void shouldThrowWhenDestinationMissing() {
		Flight badDestFlight;
		try {
			badDestFlight = new Flight("LGA", null, 2000);
			Assert.fail();
		}
		catch(IllegalArgumentException e) {
			assertEquals("Invalid destination code", e.getMessage());
		}
	}
	
	@Test
	public void shouldThrowWhenMileageTooLow() {
		Flight badMileageFlight;
		try {
			badMileageFlight = new Flight("LGA", "ORD", 99);
			Assert.fail();
		}
		catch(IllegalArgumentException e) {
			assertEquals("Mileage muse be greater than 100", e.getMessage());
		}
	}
	
	@Test
	public void shouldBeProperlyFormatted() {
		assertEquals("AA453 | DFW -> ORD | 923 miles", flight.getInfo());
	}

	@Test
	public void shouldWorkForMultipleFlights() {
		assertEquals("AA453", flight.getFullFlightNumber());
		assertEquals("WN2211", secondFlight.getFullFlightNumber());
	}

	@Test
	public void shouldAllowForUnknownFightNumbers() {
		assertEquals("UNKNOWN", unknownFlight.getFullFlightNumber());
	}
	
	@Test
	public void shouldGetDestination() {
		assertEquals("ORD", flight.getDestination());
	}

	@Test
	public void shouldGetOrigin() {
		assertEquals("DFW", flight.getOrigin());
	}

	@Test
	public void shouldGetMileage() {
		assertEquals(923, flight.getMileage());
	}

}
