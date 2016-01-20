package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.tddair.Member;
import com.tddair.TddAirApplication;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterFlyer {
	private TddAirApplication app = new TddAirApplication();
	private Member member;

	@When("^a flyer with username \"([^\"]*)\" and email \"([^\"]*)\" registers$")
	public void a_flyer_with_username_and_email_registers(String arg1, String arg2) throws Throwable {
	    
		app.registerAsMember(arg1, arg2);
	}

	@Then("^system has user with username \"([^\"]*)\"$")
	public void system_has_user_with_username(String arg1) throws Throwable {
	    member = app.lookUpMember(arg1);
	    assertNotNull(member);
	}

	@Then("^member has \"([^\"]*)\" status$")
	public void member_has_status(String arg1) throws Throwable {
		assertNotNull(member);
		assertEquals(arg1, member.getStatus().name());
	}

	@Then("^member has (\\d+) ytd miles$")
	public void member_has_ytd_miles(int arg1) throws Throwable {
		assertNotNull(member);
		assertEquals(arg1, member.getYtdMiles());
	}

	@Then("^member has (\\d+) mile balance$")
	public void member_has_mile_balance(int arg1) throws Throwable {
		assertNotNull(member);
		assertEquals(arg1, member.getMilesBalance());
	}

	@Then("^\"([^\"]*)\" is returned$")
	public void is_returned(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
