package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenCompletingFlight {

	private TddAirApplication app = new TddAirApplication();
	private Member member;
	private String username = "bob";
	
	@Before
	public void setup() {
		String email = "bob@bob.com";
		
		member = new Member(username, email);
	}
	
	@Test
	public void shouldStayAtRedStatus()
	{
		member.setStatus(Constants.RED_STATUS);
		member.setYtdMiles(500);
		app.completeFlight(member, "AA242");
		
		assertEquals(Constants.STATUS_MAP.get(Constants.RED_STATUS), member.getStatus());
	}
	
	@Test
	public void shouldStayAtGreenStatus()
	{
		member.setStatus(Constants.GREEN_STATUS);
		member.setYtdMiles(26000);
		app.completeFlight(member, "AA242");
		
		assertEquals(Constants.STATUS_MAP.get(Constants.GREEN_STATUS), member.getStatus());
	}
	
	@Test
	public void shouldStayAtBlueStatus()
	{
		member.setStatus(Constants.BLUE_STATUS);
		member.setYtdMiles(55000);
		app.completeFlight(member, "AA242");
		
		assertEquals(Constants.STATUS_MAP.get(Constants.BLUE_STATUS), member.getStatus());
	}
	
	@Test
	public void shouldStayAtGoldenStatus()
	{
		member.setStatus(Constants.GOLDEN_STATUS);
		member.setYtdMiles(76000);
		app.completeFlight(member, "AA242");
		
		assertEquals(Constants.STATUS_MAP.get(Constants.GOLDEN_STATUS), member.getStatus());
	}
	
	@Test
	public void shouldBePromotedToGreenStatus()
	{
		member.setStatus(Constants.RED_STATUS);
		member.setYtdMiles(24999);
		app.completeFlight(member, "AA242");
		
		assertEquals(Constants.STATUS_MAP.get(Constants.GREEN_STATUS), member.getStatus());
	}
	
	@Test
	public void shouldBePromotedToBlueStatus()
	{
		member.setStatus(Constants.GREEN_STATUS);
		member.setYtdMiles(49999);
		app.completeFlight(member, "AA242");
		
		assertEquals(Constants.STATUS_MAP.get(Constants.BLUE_STATUS), member.getStatus());
	}
	
	@Test
	public void shouldBePromotedToGoldendStatus()
	{
		member.setStatus(Constants.BLUE_STATUS);
		member.setYtdMiles(74999);
		app.completeFlight(member, "AA242");
		
		assertEquals(Constants.STATUS_MAP.get(Constants.GOLDEN_STATUS), member.getStatus());
	}
	
	@Test
	public void shouldNotBeDemotedFromGoldenStatus()
	{
		member.setStatus(Constants.GOLDEN_STATUS);
		member.setYtdMiles(0);
		app.completeFlight(member, "AA242");
		
		assertEquals(Constants.STATUS_MAP.get(Constants.GOLDEN_STATUS), member.getStatus());
	}
	
	@Test
	public void shouldNotBeDemotedFromBlueStatus()
	{
		member.setStatus(Constants.BLUE_STATUS);
		member.setYtdMiles(0);
		app.completeFlight(member, "AA242");
		
		assertEquals(Constants.STATUS_MAP.get(Constants.BLUE_STATUS), member.getStatus());
	}
	
	@Test
	public void shouldNotBeDemotedFromGreenStatus()
	{
		member.setStatus(Constants.GREEN_STATUS);
		member.setYtdMiles(0);
		app.completeFlight(member, "AA242");
		
		assertEquals(Constants.STATUS_MAP.get(Constants.GREEN_STATUS), member.getStatus());
	}

}
