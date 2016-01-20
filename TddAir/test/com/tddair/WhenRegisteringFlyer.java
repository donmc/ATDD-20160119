package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.tddair.exceptions.DuplicateUserNameException;

public class WhenRegisteringFlyer {
	private TddAirApplication app;
	private Member member;
	
	@Before
	public void setup() throws DuplicateUserNameException {
		this.app = new TddAirApplication();
		
		//setup
		String userName = "test1";
		String email = "test1@tddair.com";
		this.app.registerAsMember(userName, email);
		this.member = app.lookUpMember(userName);
		
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
	
	@Test
	public void shouldHave0YTDMiles() {
		assertEquals("Initial YTD balance should be 0", 
				0, member.getYtdBalance());
	}
	
	@Test(expected = DuplicateUserNameException.class)
	public void duplicateMemberRegistrationNotAllowed() throws Exception {
		String userName = "test1";
		String email = "test1@tddair.com";
		this.app.registerAsMember(userName, email);
	}
	
	@Test
	public void shouldAllowNewUserWithSameEmail() throws Exception {
		String userName = "test2";
		String email = "test1@tddair.com";
		this.app.registerAsMember(userName, email);
		
		assertEquals(2, this.app.getRegisteredMembers().size());
	}
}
