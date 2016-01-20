package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenRegisteringFlyer {

	private Member member1;
	private Member member2;
	
	@Before
	public void setup(){
		String username = "donmc";
		String username2 = "frankr";
		String email = "don@improving.com";
		TddAirApplication app = new TddAirApplication();
		app.registerAsMember(username, email);
		app.registerAsMember(username2, email);
		member2 = app.lookUpMember(username2);
		member1 = app.lookUpMember(username);
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
	

	@Ignore 
	@Test
	public void shouldHaveRedStatus(){
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldHave0YtdMiles(){
		fail("Not yet implemented");
	}
}
