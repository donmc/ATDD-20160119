package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenRegisteringFlyer {

	private Member member;
	
	@Before
	public void setup() {
		//setup
		String userName = "test1";
		String email = "test1@tddair.com";
		TddAirApplication app = new TddAirApplication();
		app.registerAsMember(userName, email);
		
		member = app.lookUpMember(userName);
		
		assertNotNull("Test Member should have been initialized to non-null", this.member);
	}
	
	@Test
	public void shouldSaveAsMember() {
		assertEquals("test1", member.getUserName());
	}

	@Test
	public void shouldHaveRedStatus() {
		assertEquals("Initial status should be Red", 
				"Red", member.getStatus());
	}
	
	@Test
	public void shouldHave10000BonusMilesForBalance() {
		assertEquals("Initial balance should be 10,000", 
				10000, member.getRewardBalance());
	}
	
	@Ignore
	@Test
	public void shouldHave0YTDMiles() {
		fail("Not implemented");
	}
}
