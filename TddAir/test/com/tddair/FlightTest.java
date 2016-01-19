package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FlightTest {

	@Test( expected = IllegalArgumentException.class )
	public void testExceptionThrown_WithNoOrigin() {
		Flight flight = new Flight(null, "SAN", 400, "AA", 1234);
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void testExceptionThrown_WithInvalidOriginLength() {
		Flight flight = new Flight("DFWX", "SAN", 400, "AA", 1234);
	}

	@Test
	public void testExceptionThrown_WithNoDestination() {
		try {
			Flight flight = new Flight("DFW", null, 400, "AA", 1234);
			fail("IllegalArgumentException expected.");
		} catch (IllegalArgumentException e){
			assertEquals("Invalid destination code", e.getMessage());
		}
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void testExceptionThrown_WithInvalidDestinationLength() {
		Flight flight = new Flight("DFW", "SANX", 400, "AA", 1234);
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void testExceptionThrown_WithInvalidMileage() {
		Flight flight = new Flight("DFW", "SAN", 99);
	}
	
	@Test
	public void testGetFullFlightNumber() {
		// setup
		Flight flight = new Flight("DFW", "SAN", 400, "AA", 1234);
		
		// excercise
		String flightNumber = flight.getFullFlightNumber();
		
		// verify
		assertEquals("AA1234",flightNumber);
	}
	
	@Test
	public void testGetFullFlightNumber_NoAirline() {
		// setup
		Flight flight = new Flight("DFW", "SAN", 400, null, 1234);
		
		// excercise
		String flightNumber = flight.getFullFlightNumber();
		
		// verify
		assertEquals("UNKNOWN",flightNumber);
	}
	
	@Test
	public void testGetFullFlightNumber_NoFlightNumber() {
		// setup
		Flight flight = new Flight("DFW", "SAN", 400, "AA", 0);
		
		// excercise
		String flightNumber = flight.getFullFlightNumber();
		
		// verify
		assertEquals("UNKNOWN",flightNumber);
	}
	
	@Test
	public void testGetFlightInfo() {
		// setup
		Flight flight = new Flight("DFW", "ORD", 920, "AA", 453);
		
		// excercise
		String flightNumber = flight.getInfo();

		// verify
		assertEquals("AA453 | DFW -> ORD | 920 miles", flightNumber);
	}
	
	@Test
	public void testGetFlightInfoForMoreFlights() {
		// setup
		Flight flight = new Flight("MIA", "LAX", 3000, "DL", 123);
		
		// excercise
		String flightNumber = flight.getInfo();

		// verify
		assertEquals("DL123 | MIA -> LAX | 3000 miles", flightNumber);
	}

}
