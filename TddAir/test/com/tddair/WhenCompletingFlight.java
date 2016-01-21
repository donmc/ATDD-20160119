package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.tddair.constants.Status;

public class WhenCompletingFlight {
	
	private TddAirApplication app;
	
	@Before
	public void before() {
		this.app = new TddAirApplication();
	}
	
	@Test
	public void completeFlightHitExactThresholdTriggersUpgrade() throws Exception {
		app.addFlight("DFW", "DAL", 101, "WN", 111);
		final Flight wn111 = app.getFlight("WN111");
		
		final int mileageSoNextFlightHitsThreshold = 
				Status.GREEN.getMinLevelMiles() - wn111.getMileage();
		
		final Member test1 = new Member("test1", "test1@example.com", 
				Status.RED, 0, mileageSoNextFlightHitsThreshold);
		app.getMemberDAO().add(test1);
		
		app.completeFlight(test1, "WN111");
		final Member test1Updated = app.lookUpMember("test1");
		
		assertEquals(Status.GREEN, test1Updated.getStatus());
	}
}
