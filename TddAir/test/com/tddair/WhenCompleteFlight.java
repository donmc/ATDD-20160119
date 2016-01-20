package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenCompleteFlight {

	private TddAirApplication app;
	
	@Before
	public void setup(){
		String username = "donmc";
		app = new TddAirApplication();
	}
	
	@Test
	public void memberSuccessfullyCompletesFlightAndAddsNewMileage() {
		Member newMember = new Member("donmc");
		newMember.setMilesBalance(new Integer(1000));
		Flight completedFlight = new Flight("DFW", "SAT", 500);
		newMember.completeFlight(completedFlight);
		assertEquals(new Integer( 1500), newMember.getMilesBalance());
	}
	

	
}
