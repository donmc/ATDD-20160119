package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FlightTest {

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionThrownNoOrigin() {
		new Flight(null, "SAT", 1234);
	}

	@Test
	public void testExceptionThrownNoDestination() {
		try {
			new Flight("DFW", null, 1234);
			fail("Should throw IllegalArgumentException");
		} catch (Exception e) {
			assertEquals("Invalid destination code", e.getMessage());
		}
	}

	@Test
	public void testOriginIsValid() {
		// setup
		Flight flight = new Flight("DFW", "SAN", 400, "AA", 1234);

		// verify
		assertNotNull(flight);
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
	public void testGetFullFlightNumberAirlineNull() {
		// setup
		Flight flight = new Flight("DFW", "SAN", 400, null, 1234);

		// exercise
		String flightNumber = flight.getFullFlightNumber();

		// verify
		assertEquals("UNKNOWN", flightNumber);
	}

	@Test
	public void testGetFullFlightNumberWhereNumberZero() {
		// setup
		Flight flight = new Flight("DFW", "SAN", 400, null, 0);

		// exercise
		String flightNumber = flight.getFullFlightNumber();

		// verify
		assertEquals("UNKNOWN", flightNumber);
	}

	@Test
	public void testOriginLengthShort() {
		try {
			new Flight("DF", null, 1234);
			fail("Should throw IllegalArgumentException");
		} catch (Exception e) {
			assertEquals("Invalid origin code", e.getMessage());
		}
	}

	@Test
	public void testOriginLengthLong() {
		try {
			new Flight("DFWFG", null, 1234);
			fail("Should throw IllegalArgumentException");
		} catch (Exception e) {
			assertEquals("Invalid origin code", e.getMessage());
		}
	}

	@Test
	public void testGetFullFightInfo() {
		// setup
		Flight flight = new Flight("DFW", "ORD", 923, "AA", 453);

		// exercise
		String fullFlightInfo = flight.getInfo();

		// verify
		assertEquals("AA453 | DFW -> ORD | 923 miles", fullFlightInfo);
	}

	@Test
	public void testGetFullFightInfo_Two() {
		// setup
		Flight flight = new Flight("DFW", "LAX", 3000, "00", 453);

		// exercise
		String fullFlightInfo = flight.getInfo();

		// verify
		assertEquals("00453 | DFW -> LAX | 3000 miles", fullFlightInfo);
	}

	@Test
	public void testGetFullFightInfo_Three() {
		// setup
		Flight flight = new Flight("DFW", "LAX", 3000, null, 453);

		// exercise
		String fullFlightInfo = flight.getInfo();

		// verify
		assertEquals("UNKNOWN | DFW -> LAX | 3000 miles", fullFlightInfo);
	}

}
