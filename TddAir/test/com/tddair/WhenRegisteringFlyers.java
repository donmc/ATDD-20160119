package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenRegisteringFlyers {
	
	private TddAirApplication app = new TddAirApplication();
	private Member member;
	private String username = "bob";

	@Before
	public void setup() {
		//String username = "bob";
		String email = "bob@bob.com";
		//TddAirApplication app = new TddAirApplication();
		app = new TddAirApplication();
		app.registerAsMember(username, email);
		member = app.lookUpMember(username);
	}

	@Test
	public void shouldSaveAsMember() {
		assertNotNull(member);
		assertEquals("bob", member.getUserName());
	}
	
	@Test(expected=DuplicateMemberException.class)
	public void shouldNotAllowDuplicateUsername() {
		String dupUsername = username;
		String diffemail = "abc@abc.com";
		app.registerAsMember(dupUsername, diffemail);
	}
	
	@Test
	public void shouldHaveRedStatus() {
		assertEquals(Status.Red, member.getStatus());
	}
	
	@Test
	public void shouldHave10000BonusMilesForBalance() {
		assertEquals(10000, member.getMilesBalance());
	}
	
	@Test
	public void shouldHave0YtdMiles() {
		assertEquals(0, member.getYtdMiles());
	}
	
	

}
