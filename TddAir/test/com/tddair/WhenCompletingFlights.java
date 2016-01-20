package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenCompletingFlights {

	TddAirApplication tddAir;
	
	@Before
	public void setup()
	{
		tddAir = new TddAirApplication();
		tddAir.registerAsMember("martymc", "martymc@;laksjdf.com");
		
	}
	
	@Test
	public void shouldHaveBalanceInYTDUpdatedAfterCompleteFlight() {
		
		Flight flight = tddAir.getFlight("AA242");
		Member member = tddAir.lookUp("martymc");
		int calculatedYTDMiles = member.getYtdMiles() + flight.getMileage();
		tddAir.completeFlight(member,flight);
		
		assertEquals(member.getYtdMiles(),calculatedYTDMiles);
	}

	@Test
	public void shouldHaveBalanceUpdatedAfterCompleteFlight() {
		Flight flight = tddAir.getFlight("AA242");
		Member member = tddAir.lookUp("martymc");
		int calculatedBalance = member.getBalance() + flight.getMileage();
		tddAir.completeFlight(member,flight);
		
		assertEquals(member.getBalance(),calculatedBalance);
	}
	
	@Test
	public void shouldHaveRedStatusTurnGreen() {
		Member marty = tddAir.lookUp("martymc");
		
		Flight flight = tddAir.getFlight("QF191");
		int miles = flight.getMileage();
		for (int total=marty.getYtdMiles(); total < 25000; total+=miles) {
			marty.completeFlight(flight);
		}
		
		assertEquals(marty.getStatus(), Status.GREEN);
		
	}
	
	@Ignore
	@Test
	public void shouldHaveGreenStatusStayGreen() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldHaveGreenStatusTurnBlue() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldHaveBlueStatusTurnGold() {
		fail("Not yet implemented");
	}

	

}
