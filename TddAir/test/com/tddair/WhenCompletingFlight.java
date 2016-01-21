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
		member.setStatus(Status.Red);
		member.setYtdMiles(500);
		app.completeFlight(member, "AA242");
		
		assertEquals(Status.Red, member.getStatus());
	}
	
	@Test
	public void shouldStayAtGreenStatus()
	{
		member.setStatus(Status.Green);
		member.setYtdMiles(26000);
		app.completeFlight(member, "AA242");
		
		assertEquals(Status.Green, member.getStatus());
	}
	
	@Test
	public void shouldStayAtBlueStatus()
	{
		member.setStatus(Status.Blue);
		member.setYtdMiles(55000);
		app.completeFlight(member, "AA242");
		
		assertEquals(Status.Blue, member.getStatus());
	}
	
	@Test
	public void shouldStayAtGoldenStatus()
	{
		member.setStatus(Status.Golden);
		member.setYtdMiles(76000);
		app.completeFlight(member, "AA242");
		
		assertEquals(Status.Golden, member.getStatus());
	}
	
	@Test
	public void shouldBePromotedToGreenStatus()
	{
		member.setStatus(Status.Red);
		member.setYtdMiles(24999);
		app.completeFlight(member, "AA242");
		
		assertEquals(Status.Green, member.getStatus());
	}
	
	@Test
	public void shouldBePromotedToBlueStatus()
	{
		member.setStatus(Status.Green);
		member.setYtdMiles(49999);
		app.completeFlight(member, "AA242");
		
		assertEquals(Status.Blue, member.getStatus());
	}
	
	@Test
	public void shouldBePromotedToGoldendStatus()
	{
		member.setStatus(Status.Blue);
		member.setYtdMiles(74999);
		app.completeFlight(member, "AA242");
		
		assertEquals(Status.Golden, member.getStatus());
	}
	
	@Test
	public void shouldNotBeDemotedFromGoldenStatus()
	{
		member.setStatus(Status.Golden);
		member.setYtdMiles(0);
		app.completeFlight(member, "AA242");
		
		assertEquals(Status.Golden, member.getStatus());
	}
	
	@Test
	public void shouldNotBeDemotedFromBlueStatus()
	{
		member.setStatus(Status.Blue);
		member.setYtdMiles(0);
		app.completeFlight(member, "AA242");
		
		assertEquals(Status.Blue, member.getStatus());
	}
	
	@Test
	public void shouldNotBeDemotedFromGreenStatus()
	{
		member.setStatus(Status.Green);
		member.setYtdMiles(0);
		app.completeFlight(member, "AA242");
		
		assertEquals(Status.Green, member.getStatus());
	}

}
