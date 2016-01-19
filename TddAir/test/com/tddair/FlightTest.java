package com.tddair;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class FlightTest {

	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrownWithNoOrigin() {
		new Flight(null, "DFW", 101);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrownWithInvalidOrigin() {
		new Flight("Dallas", "EWR", 101);
	}

	@Test
	public void testExceptionThrownWithNoDestination() {
		try {
			new Flight("DFW", null, 400);
			fail("Should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Invalid destination code");
		}		
	}

	@Test
	public void testGetFullFlightNumber() {
		// setup
		Flight flight = new Flight("DFW", "SAN", 400, "AA", 1234);
		
		// exercise
		String flightNumber = flight.getFullFlightNumber();
		
		// verify
		assertEquals("AA1234", flightNumber);
	}
	
	@Test
	public void testGetFullFlightNumber_NoFlightNo() {
		// setup
		Flight flight = new Flight("DFW", "SAN", 400, "AA", 0);
		
		// exercise
		String flightNumber = flight.getFullFlightNumber();
		
		// verify
		assertEquals("UNKNOWN", flightNumber);
	}
	
	@Test
	public void testGetFlightInfo() {
		// setup
		Flight flight = new Flight("DFW", "ORD", 923, "AA", 453);
		
		// exercise
		String flightInfo = flight.getInfo();
		
		// verify
		assertEquals("AA453 | DFW -> ORD | 923 miles", flightInfo);
	}
	
	@Test
	public void testGetFlightInfo2() {
		// setup
		Flight flight = new Flight("MIA", "LAX", 3000, "WN", 453);
		
		// exercise
		String flightInfo = flight.getInfo();
		
		// verify
		assertEquals("WN453 | MIA -> LAX | 3000 miles", flightInfo);
	}

}
