package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TddAirApplicationTest {

	@Test
	public void coverage_shouldNotThrowExceptionWhenAddingFlights() {
		TddAirApplication app = new TddAirApplication();
		app.addFlight("DAL", "ORD", 1000, "WN", 1234);
		assertNotNull(app);
	}

	@Test
	public void coverage_memberUpdateShouldPersist() {
		TddAirApplication app = new TddAirApplication();
		String username = "a";
		String email = "b";
		Flyer member = new Flyer(username, email);
		app.registerNewFlyer(member);
		assertEquals(app.getFlyer(username).getYtdMiles(), Flyer.DEFAULT_YTD_INITIAL_VALUE);
		member.setYtdMiles(5);
		app.updateMember(member);
		assertEquals(app.getFlyer(username).getYtdMiles(), 5);
	}

	@Test
	public void coverage_getFlight() {
		TddAirApplication app = new TddAirApplication();
		Flight flight = app.getFlight("QF191");
		assertNotNull(flight);
		assertEquals(flight.getFullFlightNumber(), "QF191");
	}

}
