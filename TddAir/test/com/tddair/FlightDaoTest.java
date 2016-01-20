package com.tddair;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class FlightDaoTest extends FlightDao {

	@Test
	public void shouldReturnNullWhenRequestingFlightThatDoesntExist() {
		FlightDao dao = new FlightDao();
		Flight flight = dao.getFlightBy("");
		assertNull(flight);
	}

}
