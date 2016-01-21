package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenMemberCompletesFlight {
	private TddAirApplication app = new TddAirApplication();
	private Member member;
	
	@Before
	public void setup()
	{
		member = app.lookupMember("user1234");
		if (member == null) {
			try {
				app.registerAsMember("user1234", "user1234@yahoo.com");
			} catch (Exception e) {
				e.printStackTrace();
			}
			member = app.lookupMember("user1234");
		}
		member.setYtdMiles(20000);
		member.setBalanceMiles(30000);
		member.setStatus(MemberStatus.RED);
	}
	
	@Test
	public void shouldNotChangeStatus() {		
		app.completeFlight("user1234", "AA242");
		assertNotNull(member); 
		assertEquals(MemberStatus.RED, member.getStatus());
		assertEquals(20924, member.getYtdMiles());
		assertEquals(30924, member.getBalanceMiles());
	}
	
	@Test
	public void shouldNotChangeStatus_WithNonExistantFlight() {		
		app.completeFlight("user1234", "AB123");
		assertNotNull(member); 
		assertEquals(MemberStatus.RED, member.getStatus());
		assertEquals(20000, member.getYtdMiles());
		assertEquals(30000, member.getBalanceMiles());
	}
	
	@Test
	public void shouldNotCompleteFlight_WithNonExistantMember() {		
		app.completeFlight("nonExistant", "AA242");
		member = app.lookupMember("nonExistant");
		assertNull(member); 
		
	}
	
	@Test
	public void shouldHaveGreenStatus() {		
		app.completeFlight("user1234", "QF191");
		assertNotNull(member); 
		assertEquals(MemberStatus.GREEN, member.getStatus());
		assertEquals(27490, member.getYtdMiles());
		assertEquals(37490, member.getBalanceMiles());
	}

	@Test
	public void shouldHaveBlueStatus() {
		app.addFlight("DFW", "CGK", 30001, "SQ", 91);
		app.completeFlight("user1234", "SQ91");
		assertNotNull(member); 
		assertEquals(MemberStatus.BLUE, member.getStatus());
		assertEquals(50001, member.getYtdMiles());
		assertEquals(60001, member.getBalanceMiles());
	}
	
	@Test
	public void shouldHaveGoldenStatus() {
		app.addFlight("NYC", "DXB", 60001, "SQ", 999);
		app.completeFlight("user1234", "SQ999");
		assertNotNull(member); 
		assertEquals(MemberStatus.GOLDEN, member.getStatus());
		assertEquals(80001, member.getYtdMiles());
		assertEquals(90001, member.getBalanceMiles());
	}
}
