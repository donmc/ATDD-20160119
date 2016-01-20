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
	public void memberSuccessfullyCompletesFlightAndAddsNewMileage() {
		setUpMember(1000, 1000, 500);
		newMember.completeFlight(completedFlight);
		assertEquals(new Integer( 1500), newMember.getMilesBalance());
	}
	
	@Test
	public void memberSuccessfullyCompletesFlightAndAddsNewYtdMileage() {
		setUpMember(1000, 1000, 500);
		newMember.completeFlight(completedFlight);
		assertEquals(new Integer( 1500), newMember.getYtdMiles());
	}
	
	@Test
	public void memberSuccessfullyCompletesFlightAndProgressesFromRedToGreen() {
		setUpMember(1000, 24000, 1200, Category.Red);
		newMember.completeFlight(completedFlight);
		assertEquals(Category.Green, newMember.getStatus());
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
