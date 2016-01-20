package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenRegisteringFlyers {

	@Before
	public void setup() {
		//setup
		String username = "donmc";
		String email = "don@improving.com";
		TddAirApplication app = new TddAirApplication();
		app.registerAsMember(username, email);
		
		Member member = app.lookUpMember(username);
	}
	
	@Test
	public void shouldSaveAsMember() {
		assertNotNull(member);
		assertEquals("donmc", member.getUserName());
	}
	
	@Ignore
	@Test
	public void shouldHaveRedStatus() {
		
	}
	
	@Ignore
	@Test
	public void shouldhave10000BonusMilesForBalance() {
		
	}
	
	@Ignore
	@Test
	public void shouldHave0YtdMiles() {
		
	}

}
