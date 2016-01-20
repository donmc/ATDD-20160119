package com.tddair;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class FlightTest {

	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrownWithNoOrigin() {
		new Flight(null, "DFW", 400);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrownWithInvalidOrigin() {
		new Flight("DALLAS", "DFW", 400);
	}
	
	@Test
	public void testExceptionThrownWithNoDestination() {
		try {
			new Flight("DFW", null, 400);
			fail("Should throw IllegalArumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid destination code", e.getMessage());
		}
	}
	
	@Test
	public void testExceptionThrownWithInvalidDestination() {
		try {
			new Flight("DFW", "DALLAS", 400);
			fail("Should throw IllegalArumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid destination code", e.getMessage());
		}
	}
	
	@Test
	public void testExceptionThrownWithInvalidMileage() {
		try {
			new Flight("DFW", "SAN", 99);
			fail("Should throw IllegalArumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Mileage muse be greater than 100", e.getMessage());
		}
	}
	
	@Test
	public void testGetFlightInfo() {
		Flight flight = new Flight("DFW", "SAN", 400, "AA", 1234);
		
		String fullFlightInfo = flight.getFlightInfo();
		
		assertEquals("AA1234 | DFW -> SAN | 400 miles", fullFlightInfo);
	}
	
	@Ignore
	@Test
	public void testFlightStringStringIntStringInt() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFlightStringStringInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFullFlightNumber() {
		// setup 
		Flight flight = new Flight("DFW", "SAN", 400, "AA", 1234);
		
		// exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		
		// verify
		assertEquals(fullFlightNumber, "AA1234");
		
		//teardown
	}
	
	@Test
	public void testGetFullFlightNumber_NoFlight() {
		// setup 
		Flight flight = new Flight("DFW", "SAN", 400, "AA", 0);
		
		// exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		
		// verify
		assertEquals(fullFlightNumber, "UNKNOWN");
		
		//teardown
	}
	
	@Test
	public void testGetFullFlightNumber_NoAirline() {
		// setup 
		Flight flight = new Flight("DFW", "SAN", 400);
		
		// exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		
		// verify
		assertEquals(fullFlightNumber, "UNKNOWN");
		
		//teardown
	}

}
