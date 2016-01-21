package com.tddair.features;

import static org.junit.Assert.assertEquals;

import com.tddair.Member;
import com.tddair.TddAirApplication;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterFlyer {

	TddAirApplication tddAirApp = TddAirSingleton.getInstance();
	Member member;
	String registartionStatus;

	// @Given("^a flyer with username \"([^\"]*)\" and email \"([^\"]*)\"
	// registers$")
	@When("^a flyer with username \"([^\"]*)\" and email \"([^\"]*)\" registers$")
	public void a_flyer_with_username_and_email_registers(String username, String email) {
		registartionStatus = tddAirApp.registerAsMember(username, email);
	}

	@Then("^system has use with username \"([^\"]*)\"$")
	public void system_has_use_with_username(String username) {
		member = tddAirApp.lookUp(username);
		assertEquals(username, member.getUserName());
	}

	@Then("^member has \"([^\"]*)\" status$")
	public void member_has_status(String status) {
		assertEquals(member.getStatus().name(), status);
	}

	@Then("^member has (\\d+) ytdMiles$")
	public void member_has_ytdMiles(int ytdMiles) {
		assertEquals(ytdMiles, member.getYtdMiles());
	}

	@Then("^member has (\\d+) mile balance$")
	public void member_has_mile_balance(int balance) {
		assertEquals(balance, member.getBalance());
	}

	/*
	 * @Given(
	 * "^a flyer with username \"([^\"]*)\" and email \"([^\"]*)\" registers$")
	 * public void a_flyer_with_username_and_email_registers(String arg1, String
	 * arg2){ // Write code here that turns the phrase above into concrete
	 * actions throw new PendingException(); }
	 */

	@Then("^error \"([^\"]*)\" is returned$")
	public void error_is_returned(String errorMessage) {
		assertEquals(errorMessage, registartionStatus);
	}

}
