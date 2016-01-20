package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class WhenRegisteringFlyers {

	private Member member;
	
	@Before
	public void setup() {
		//setup
		TddAirApplication app = new TddAirApplication();
		app.registerAsMember("donmc", "don@improving.com");
		
		member = app.lookUpMember("donmc");
		System.out.println("Setup");
	}
	
	@Test
	public void shouldSaveAsMember() {
		assertNotNull(member);
		assertEquals("donmc", member.getUserName());
	}
	
	@Test
	public void shouldHaveRedStatus() {
		assertEquals(member.getStatus(), Status.RED);
	}
	
	@Test
	public void shouldhave10000BonusMilesForBalance() {
		assertEquals(member.getMilesBalance(), 10000);
	}
	
	@Test
	public void shouldHave0YtdMiles() {
		assertEquals(member.getYtdMiles(), 0);
	}

}
