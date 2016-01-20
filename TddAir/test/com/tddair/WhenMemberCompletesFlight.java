package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenMemberCompletesFlight {

	private Member member;
	private static boolean isSetupDone = false;
	
	@Before
	public void setup()
	{
		TddAirApplication app = new TddAirApplication();
		if (!isSetupDone) {
			try {
				app.registerAsMember("user1234", "user1234@yahoo.com");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			isSetupDone = true;
		}
		app.addFlight("SAT", "DAC", 7490, "QF", 191);
		member = app.lookupMember("user1234");
		member.setYtdMiles(20000);
		member.setBalanceMiles(30000);
		member.setStatus(MemberStatus.RED);
		
		app.completeFlight("user1234", "QF191");
	}
	
	@Test
	public void shouldHaveRightStatus() {
		assertNotNull(member); 
		assertEquals("GREEN", member.getStatus().toString());
	}

	@Test
	public void shouldHaveRightYtdMilage() {
		assertNotNull(member); 
		assertEquals(27490, member.getYtdMiles());
	}
	
	@Test
	public void shouldHaveRightBalance() {
		assertNotNull(member); 
		assertEquals(37490, member.getBalanceMiles());
	}
}
