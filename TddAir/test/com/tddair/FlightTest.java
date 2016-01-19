package com.tddair;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class FlightTest {

	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrown_WhenNoOrgin() {
		setupFlight(null, "DFW", 300, "AA", 1234);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrown_WhenOrginNotValid() {
		setupFlight("ABCD", "DFW", 300, "AA", 1234);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrown_WhenNoDestination() {
		new Flight("LBK", null , 300);
		fail("Should throw Illegal Argument Exception.");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrown_WhenDestinationNotValid() {
		new Flight("LBK", "ABCD" , 300);
		fail("Should throw Illegal Argument Exception.");
	}
	
	@Test
	public void testFlight_NoAirlineOrFlightNumber() {
		new Flight("DFW", "SAT", 400);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFlight_MillageLessThan100_ShouldThrowIllegalArgumentException() {
		new Flight("DFW", "SAT", 20);
	}

	@Test
	public void testGetFullFlightNumber() {
		//setup
		Flight aFlight = setupFlight("DFW", "SAT", 300, "AA", 1234);

		//verify
		assertEquals("AA1234", aFlight.getFullFlightNumber());
	}

	@Test
	public void testGetFulLFlightNumber_WhenAirlineIsNull_ShouldReturnUnknown()
	{
		//setup
		Flight aFlight = setupFlight("DFW", "SAT", 300, null, 1234);

		//verify
		assertEquals("UNKNOWN", aFlight.getFullFlightNumber());
	}
	
	@Test
	public void testGetFullFlightNumber_WhenFlightNumberIsZero_ShouldReturnUnknown()
	{
		//setup
		Flight aFlight = setupFlight("DFW", "SAT", 300, "AA", 0);
		
		//verify
		assertEquals("UNKNOWN", aFlight.getFullFlightNumber());
	}
	
	@Test
	public void testGetFullFlightNumber_WhenFlightNumberIsZeroAndAirlineIsNull_ShouldReturnUnknown()
	{
		//setup
		Flight aFlight = setupFlight("DFW", "SAT", 300, null, 0);
		
		//verify
		assertEquals("UNKNOWN", aFlight.getFullFlightNumber());
	}
	
	@Test
	public void testGetFlightInfo()
	{
		Flight aFlight = setupFlight("DFW", "SAT", 300, "NW", 123);
		
		assertEquals("NW123|DFW -> SAT|300 miles", aFlight.getInfo());
	}
	
	@Test
	public void testGetFlightInfo_WhenAirlineIsUnknown()
	{
		Flight aFlight = setupFlight("DFW", "SAT", 300, null, 123);
		
		assertEquals("UNKNOWN|DFW -> SAT|300 miles", aFlight.getInfo());
	}
	
	@Test
	public void testGetFlightInfo_WhenFlightNumberIsZero()
	{
		Flight aFlight = setupFlight("DFW", "SAT", 300, "NW", 0);
		
		assertEquals("UNKNOWN|DFW -> SAT|300 miles", aFlight.getInfo());
	}
	
	
	private Flight setupFlight(String orgin, String destination, int millage, String airline, int flightNumber)
	{
		return new Flight(orgin, destination, millage, airline, flightNumber);
	}

}
