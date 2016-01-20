package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class WhenRegisteringFlyers 
{
	private Member member = null;
	private TddAirApplication tddAirApp = null;


	@Before
	public void setup()
	{
		String username = "martym";
		String email = "martymcfly@future.com";
		tddAirApp = new TddAirApplication();
		tddAirApp.registerAsMember(username, email);
		
		member = tddAirApp.lookUp(username);
	}
	
	@Test
	public void shouldSaveAsMember() 
	{
		assertNotNull(member);
		assertEquals("martym", member.getUserName());
	}
	
	@Test
	public void shouldNotSaveDuplicateMember() 
	{
		//Setup
		tddAirApp.registerAsMember("martym", "marty2mcfly@future.com");
		Member duplicateMember = tddAirApp.lookUp("martym");
		
		assertNotNull(duplicateMember);
		assertNotEquals("marty2mcfly@future.com", member.getEmail());
	}
	
	@Test
	public void shouldReturnDuplicateMemberErrorMessage() 
	{
		//Setup
		String registrationStatus = tddAirApp.registerAsMember("martym", "marty2mcfly@future.com");

		assertEquals(MemberConstants.REGISTRATION_DUPLICATE, registrationStatus);
	}

	@Test
	public void shouldHaveRedStatus() 
	{

		Status status = member.getStatus();
		assertEquals(Status.RED, status);
	}
	
	@Test
	public void shouldHave10000BonusMilesForBalance() 
	{
		int balance = member.getBalance();
		assertEquals(10000,balance);
	}
	
	@Test
	public void shouldHave0YTD() 
	{
		int ytdMiles = member.getYtdMiles();
		assertEquals(0, ytdMiles);
	}
}
