package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenGeneratingFlightInfo {
	
	private Flight firstFlight;
	private Flight secondFlight;
	private Flight unknownFlight;
	
	@Before
	public void setup() {
		firstFlight = new Flight("DWF", "SAN", 350, "AA", 1234);
		secondFlight = new Flight("MIL", "WAX", 567, "SN", 721);
		unknownFlight = new Flight("LAX", "CHI", 325);

	}

	@Test
	public void shouldBeProperlyFormatted() {
		assertEquals("AA1234|DWF->SAN|350miles", firstFlight.getFlightInfo());
	}
	
	@Test
	public void shouldWorkForMultipleFlights() {
		assertEquals("SN721|MIL->WAX|567miles", secondFlight.getFlightInfo());
	}
	
	@Test
	public void shouldAllowForUnknownFlightNumbers() {
		assertEquals("UNKNOWN|LAX->CHI|325miles", unknownFlight.getFlightInfo());
	}
	
	
}
