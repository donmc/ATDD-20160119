package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FlightTest {

	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrownWithNoOrigin() {
		new Flight(null, "DFW", 1234);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrownWithInvalidOrigin() {
		new Flight("Dallas", "DFW", 1234);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrownWithInvalidMilage() {
		new Flight("DFW", "DFW", -1234);
	}
	
	@Test
	public void testExceptionThrownWithNoDestination() {

		try {
			new Flight("DFW", null, 1234);
			fail("should throw Exception from line above !!");
		} catch (IllegalArgumentException e) {

			assertEquals("Invalid destination code", e.getMessage());
		}

	}
	
	@Test
	public void testExceptionThrownWithInvalidDestination() {

		try {
			new Flight("DFW", "SAN FRANCISCO", 1234);
			fail("should throw Exception from line above !!");
		} catch (IllegalArgumentException e) {

			assertEquals("Invalid destination code", e.getMessage());
		}

	}

	@Test
	public void testGetFullFlightNumber() {
		
		//setup
		Flight flight = new Flight("DFW", "SAN", 400, "AA", 1234);
		
		//exercise 
		String fullFlightNumber = flight.getFullFlightNumber();	
		
		//verify
		assertEquals("AA1234", fullFlightNumber);
		
		//tear down 
	}
	
	@Test
	public void testGetFullFlightNumber_NoFlightName() {
		
		//setup
		Flight flight = new Flight("DFW", "SAN", 400, null, 1234);
		
		//exercise 
		String fullFlightNumber = flight.getFullFlightNumber();	
		
		//verify
		assertEquals("UNKNOWN", fullFlightNumber);
		
		//tear down 
	}
	
	@Test
	public void testGetFullFlightNumber_NoFlightNumber() {
		
		//setup
		Flight flight = new Flight("DFW", "SAN", 400, "AA", 0);
		
		//exercise 
		String fullFlightNumber = flight.getFullFlightNumber();	
		
		//verify
		assertEquals("UNKNOWN", fullFlightNumber);
		
		//tear down 
	}
	
	@Test
	public void testGetFullFlightInfo() {
		
		//setup
		Flight flight = new Flight("DFW", "ORD", 920, "AA", 453);
		
		//exercise 
		String fullFlightInfo = flight.getInfo();	
		
		//verify
		assertEquals("AA453 | DFW -> ORD | 920", fullFlightInfo);
		
		//tear down 
	}
	
	@Test
	public void testGetFullFlightInfoForMoreFlights() {
		
		//setup
		Flight flight = new Flight("MIA", "LAX", 3000, "WN", 2311);
		
		//exercise 
		String fullFlightInfo = flight.getInfo();	
		
		//verify
		assertEquals("WN2311 | MIA -> LAX | 3000", fullFlightInfo);
		
		//tear down 
	}
	
	@Test
	public void testGetFullFlightInfoForUnknownFlights() {
		
		//setup
		Flight flight = new Flight("MIA", "LAX", 3000);
		
		//exercise 
		String fullFlightInfo = flight.getInfo();	
		
		//verify
		assertEquals("UNKNOWN | MIA -> LAX | 3000", fullFlightInfo);
		
		//tear down 
	}
}
