package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenCompleteFlight {

	private TddAirApplication app;
	private Member newMember;
	private Flight completedFlight;
	
	@Before
	public void setup(){
		String username = "donmc";
		app = new TddAirApplication();
	}
	
	@Test
	public void memberSuccessfullyCompletesFlightAndAddsNewMileage() throws FlightNotFoundException {
		setUpMember(1000, 1000, 500);
		newMember.completeFlight(completedFlight);
		assertEquals(new Integer( 1500), newMember.getMilesBalance());
	}
	
	@Test
	public void memberSuccessfullyCompletesFlightAndAddsNewYtdMileage() throws FlightNotFoundException {
		setUpMember(1000, 1000, 500);
		newMember.completeFlight(completedFlight);
		assertEquals(new Integer( 1500), newMember.getYtdMiles());
	}
	
	@Test
	public void memberSuccessfullyCompletesFlightAndProgressesFromRedToGreen() throws FlightNotFoundException {
		setUpMember(1000, 24000, 1200, Category.Red);
		newMember.completeFlight(completedFlight);
		assertEquals(Category.Green, newMember.getStatus());
	}
	
	@Test
	public void memberSuccessfullyCompletesFlightAndStaysGreen() throws FlightNotFoundException {
		setUpMember(1000, 26000, 1200, Category.Green);
		newMember.completeFlight(completedFlight);
		assertEquals(Category.Green, newMember.getStatus());
	}
	
	@Test
	public void memberSuccessfullyCompletesFlightAndStaysGreenDespiteSmallYtdMiles() throws FlightNotFoundException {
		setUpMember(1000, 100, 1200, Category.Green);
		newMember.completeFlight(completedFlight);
		assertEquals(Category.Green, newMember.getStatus());
	}
	
	@Test
	public void memberSuccessfullyCompletesFlightAndProgressesFromGreenToBlue() throws FlightNotFoundException {
		setUpMember(1000, 49000, 1200, Category.Green);
		newMember.completeFlight(completedFlight);
		assertEquals(Category.Blue, newMember.getStatus());
	}
	
	@Test
	public void memberSuccessfullyCompletesFlightAndProgressesFromBlueToGolden() throws FlightNotFoundException {
		setUpMember(1000, 74000, 1200, Category.Blue);
		newMember.completeFlight(completedFlight);
		assertEquals(Category.Golden, newMember.getStatus());
	}
	
	@Test
	public void memberSuccessfullyCompletesFlightWithNullFlight() {
		setUpMember(1000, 74000, 1200, Category.Blue);
		try
		{
			newMember.completeFlight(null);
			fail("Exception not thrown");
		}
		catch(FlightNotFoundException exception)
		{
			assertEquals("No flight found", exception.getMessage());
		}
		
	}
	
	private void setUpMember(Integer currentMiles, Integer ytdMiles, int flightMiles, Category status)
	{
		setUpMember(currentMiles, ytdMiles, flightMiles);
		newMember.setStatus(status);
	}
	
	private void setUpMember(Integer currentMiles, Integer ytdMiles, int flightMiles)
	{
		newMember = new Member("donmc");
		newMember.setMilesBalance(currentMiles);
		newMember.setYtdMiles(ytdMiles);
		completedFlight = new Flight("DFW", "SAT", flightMiles);
	}
	
}
