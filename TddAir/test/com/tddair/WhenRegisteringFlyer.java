package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenRegisteringFlyer {

	private Member member1;
	
	@Before
	public void setup(){
		String username = "donmc";
		String email = "don@improving.com";
		TddAirApplication app = new TddAirApplication();
		app.registerAsMember(username, email);
		member1 = app.lookUpMember(username);
	}
	
	@Ignore 
	@Test
	public void shouldSaveAsMember() {
		//setup
		assertNotNull(member1);
		assertEquals( "donmc", member1.getUserName());
		
		
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
