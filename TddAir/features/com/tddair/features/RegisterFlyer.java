package com.tddair.features;

import static org.junit.Assert.assertEquals;

import com.tddair.Member;
import com.tddair.TddAirApplication;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterFlyer {

	TddAirApplication app = new TddAirApplication();

	@When("^a flyer with username \"([^\"]*)\" and email \"([^\"]*)\" registers$")
	public void a_flyer_with_username_and_email_registers(String arg1, String arg2) throws Throwable {
		app.registerAsMember(arg1, arg2);
		Member member = app.lookUpMember(arg1);
		assertEquals(arg1, member.getUserName());
	}

	@Then("^system has user with username \"([^\"]*)\"$")
	public void system_has_user_with_username(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^member has \"([^\"]*)\" status$")
	public void member_has_status(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^member has (\\d+) ytdMiles$")
	public void member_has_ytdMiles(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^member has (\\d+) mile balance$")
	public void member_has_mile_balance(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^error \"([^\"]*)\" is returned$")
	public void error_is_returned(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
