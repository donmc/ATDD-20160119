package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WhenCompletingFlights {
	@Test
	public void shouldUpdateMilesWhenCompletingAFlight() {
		Flyer flyer = new Flyer("username", "email");
		Flight flight = new Flight("DFW", "LAX", 3000);
		int beforeMilesBalance = flyer.getBalance();
		int beforeYtdMiles = flyer.getYtdMiles();

		flyer.completeFlight(flight);
		assertEquals(flyer.getBalance(), beforeMilesBalance + 3000);
		assertEquals(flyer.getYtdMiles(), beforeYtdMiles + 3000);

	}
}
