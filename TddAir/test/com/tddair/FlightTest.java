package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FlightTest {


	@Test(expected=IllegalArgumentException.class)
	public void testFlightExceptionThrownWithNoOrigin() {
		new Flight(null,"SAN", 1234);
	}
	
	@Test
	public void testFlightThrownWithNoDestination() {
			try {
				new Flight("DFW", null, 1231);
				fail("Should not get to this line as it threw an illegal argument exception");
			} catch (IllegalArgumentException e) {
				assertEquals("Invalid destination code", e.getMessage());
			}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFlightExceptionThrownWithOriginGreaterThan3() {
		new Flight("DALLAS","SAN", 1234);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFlightExceptionThrownWithDestinationGreaterThan3() {
		new Flight("DAL","SAN ANTONIO", 1234);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFlightExceptionThrownWithDestinationNull() {
		new Flight("DAL",null, 1234);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFlightExceptionThrowWithMileageZero() {
		new Flight("DFW", "SAN", 0, "AA", 1234); 
	}
	
	@Test
	public void testGetFullFlightNumber() { 
		//setup
		Flight testFlight = new Flight("DFW", "SAN", 400, "AA", 1234);
		
		//exercise
		String flightNumber = testFlight.getFullFlightNumber();
		
		//verify
		assertEquals("AA1234", flightNumber);
		
	}
	@Test
	public void testGetFullFlightNumber_NoFlightNo() { 
		//setup
		Flight testFlight = new Flight("DFW", "SAN", 400, "AA", 0);
		
		//exercise
		String flightNumber = testFlight.getFullFlightNumber();
		
		//verify
		assertEquals("UNKNOWN", flightNumber);
		
	}
	
	@Test
	public void testGetFullFlightNumber_NoAirline() { 
		//setup
		Flight testFlight = new Flight("DFW", "SAN", 400, null, 1234);
		
		//exercise
		String flightNumber = testFlight.getFullFlightNumber();
		
		//verify
		assertEquals("UNKNOWN", flightNumber);
		
	}
	
	
	@Test
	public void testGetDestination() {
		Flight testFlight =new Flight("DFW", "SAT", 500);
		assertEquals(testFlight.getDestination(), "SAT");
	}

	@Test
	public void testGetOrigin() {
		Flight testFlight =new Flight("DFW", "SAT", 500);
		assertEquals(testFlight.getOrigin(), "DFW");
	}


	@Test
	public void testGetMileage() {
		Flight testFlight =new Flight("DFW", "SAT", 500);
		assertEquals(testFlight.getMileage(), 500);
	}

}
