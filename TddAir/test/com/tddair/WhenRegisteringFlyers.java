package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenRegisteringFlyers 
{
	private Member member = null;

	@Before
	public void setup()
	{
		String username = "martym";
		String email = "martymcfly@future.com";
		TddAirApplication tddAirApp = new TddAirApplication();
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
	public void shouldHaveRedStatus() 
	{

		Status status = member.getStatus();
		assertEquals(Status.RED, status);
	}
	
	@Ignore
	@Test
	public void shouldHave10000BonusMilesForBalance() 
	{
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldHave0YTD() 
	{
		fail("Not yet implemented");
	}
}
