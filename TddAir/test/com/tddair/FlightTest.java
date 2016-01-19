package com.tddair;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class FlightTest {

	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrownWithNoOrigin() {
		new Flight(null, "DFW", 1203);
	}

	@Ignore
	@Test
	public void testExceptionThrownWithNoDestination() {
		try {
			new Flight("DFW", null, 1231);
			fail("Should throw");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid destination code", e.getMessage());
		}
	}

	@Test
	public void testGetFullFlightNumber() {
		// setup
		Flight flight = new Flight("DFW", "SAN", 400, "AA", 1234);

		// exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		
		// verify
		assertEquals("AA1234", fullFlightNumber);
	}
	
	@Test
	public void testGetInfo() {
		Flight flight = new Flight("DFW", "ORD", 920, "AA", 453);
		assertEquals("AA453 | DFW -> ORD | 920 miles", flight.getInfo());
	};

	@Ignore
	@Test
	public void testGetDestination() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetOrigin() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetMileage() {
		fail("Not yet implemented");
	}

}
