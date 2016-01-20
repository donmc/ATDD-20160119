package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenRegisteringFlyer {
	private Member member;
	private Member secondMember;
	private Member duplicateMember;
	TddAirApplication app = new TddAirApplication();

	@Before
	public void setup() {
		// Given
		String username = "donmc";
		String email = "donmc@gmail.com";

		// When
		app.registerAsMember(username, email);
		app.registerAsMember("dinh", "dinh@usaa.com");
		
		
		member = app.lookUpMember(username);
		duplicateMember = member;
		secondMember = app.lookUpMember("dinh");
	}
	
	@Test
	public void shouldSaveAsMember() {
		assertNotNull(member);
		assertEquals("donmc", member.getUserName());
	}
	
	@Test
	public void shouldSaveAsSecondMember() {
		assertNotNull(secondMember);
		assertEquals("dinh", secondMember.getUserName());
	}
	
	@Test
	public void shouldNotBeDuplicateMember() {
		try {
			app.registerAsMember(duplicateMember.getUserName(), null);
			fail("Cannot have duplicate username!");
		} catch (Exception e) {
			assertEquals("Username is already registered", e.getMessage());
		}
	}
	
	@Test
	public void shouldHaveRedStatus() {
		assertEquals(Status.Red, member.getStatus());
	}
	
	@Test
	public void shouldHave0YtdMiles() {
		assertEquals(0, member.getYtdMiles());
	}
	
	@Test
	public void shouldHaveInitialMiles(){
		assertEquals(10000,member.getMiles());
	}
}
