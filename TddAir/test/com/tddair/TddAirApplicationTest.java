package com.tddair;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TddAirApplicationTest {

	@Test
	public void coverage_shouldNotThrowExceptionWhenAddingFlights() {
		TddAirApplication app = new TddAirApplication();
		app.addFlight("DAL", "ORD", 1000, "WN", 1234);
		assertNotNull(app);
	}

}
