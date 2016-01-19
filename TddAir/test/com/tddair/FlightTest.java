package com.tddair;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class FlightTest {

	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrownWithNoOrigin() {
		new Flight(null, "DFW", 1203);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrownWithInvalidOriginLength() {
		new Flight("DALLAS", "DFW", 1203);
	}
	
	@Test
	public void testExceptionThrownWithNoDestination() {
		try {
			new Flight("DFW", null, 1203);
			fail("Should throw IllegalArgumentException");
		} 
		catch (IllegalArgumentException e) {
			assertEquals("Invalid destination code", e.getMessage());
		}
	}

	@Test
	public void testGetFullFlightNumber() {
		// Setup
		Flight flight = new Flight("DFW", "SAN", 400, "AA", 1234);
		
		// Excercise
		String flightNumber = flight.getFullFlightNumber();
		
		// Verify
		assertEquals("AA1234", flightNumber);
	}

	@Test
	public void testGetFullFlightNumber_NoFlightNo() {
		// Setup
		Flight flight = new Flight("DFW", "SAN", 400, null, 0);
		
		// Excercise
		String flightNumber = flight.getFullFlightNumber();
		
		// Verify
		assertEquals("UNKNOWN", flightNumber);
	}
	
	// Get Flight Info Test
	@Test
	public void testGetInfo() {
		// Setup
		Flight flight = new Flight("DFW", "ORD", 923, "AA", 453);
		
		// Excercise
		String flightInfo = flight.getInfo();
		
		// Verify
		assertEquals("AA453 | DFW -> ORD | 923 miles", flightInfo);
	}
}
