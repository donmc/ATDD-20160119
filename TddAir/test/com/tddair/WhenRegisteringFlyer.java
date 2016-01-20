package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenRegisteringFlyer {

	private Member member1;
	private Member member2;
	private Member missingMember;
	
	@Before
	public void setup(){
		String username = "donmc";
		String username2 = "frankr";
		String userMissing = "lind";
		String email = "don@improving.com";
		TddAirApplication app = new TddAirApplication();
		app.registerAsMember(username, email);
		app.registerAsMember(username2, email);
		member2 = app.lookUpMember(username2);
		member1 = app.lookUpMember(username);
		missingMember = app.lookUpMember(userMissing);
	}
	
	@Test
	public void shouldSaveAsMember() {
		//setup
		assertNotNull(member1);
		assertEquals( "donmc", member1.getUserName());
	}
	
	@Test
	public void shouldSaveAsMemberWithDifferentUserName() {
		//setup
		assertNotNull(member2);
		assertEquals( "frankr", member2.getUserName());
	}
	
	@Test
	public void shouldBeMissingFromRegisteredMembers() {
		assertNull(missingMember);
	}

	@Test
	public void shouldHaveRedStatus(){
		assertEquals(Category.Red, member1.getStatus());
	}
	
	@Ignore
	@Test
	public void shouldHave0YtdMiles(){
		fail("Not yet implemented");
	}
}
