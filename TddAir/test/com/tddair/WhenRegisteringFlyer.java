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
	}
	
	@Test
	public void shouldSaveAsMember() {
		assertNotNull(member);
		assertEquals("test1", member.getUserName());
	}

	@Ignore
	@Test
	public void shouldHaveRedStatus() {
		fail("Not implemented");
	}
	
	@Ignore
	@Test
	public void shouldHave10000BonusMilesForBalance() {
		fail("Not implemented");
	}
	
	@Ignore
	@Test
	public void shouldHave0YTDMiles() {
		fail("Not implemented");
	}
}
