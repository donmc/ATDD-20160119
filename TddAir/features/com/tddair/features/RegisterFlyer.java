package com.tddair.features;

import static org.junit.Assert.assertEquals;

import com.tddair.Member;
import com.tddair.TddAirApplication;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterFlyer {
	
	TddAirApplication tddAirApp = new TddAirApplication();
	Member member;

	@When("^a flyer with username \"([^\"]*)\" and email \"([^\"]*)\" registers$")
	public void a_flyer_with_username_and_email_registers(String username, String email) throws Throwable {
	    tddAirApp.registerAsMember(username, email);
	}
	
	@Then("^system has use with username \"([^\"]*)\"$")
	public void system_has_use_with_username(String username) throws Throwable {
		member = tddAirApp.lookUp(username);
		assertEquals(username, member.getUserName());
	}

	@Then("^member has \"([^\"]*)\" status$")
	public void member_has_status(String status) throws Throwable {
	    assertEquals(member.getStatus().name(), status);
	}

	@Then("^member has (\\d+) ytdMiles$")
	public void member_has_ytdMiles(int ytdMiles) throws Throwable {
	    assertEquals(ytdMiles, member.getYtdMiles());
	}

	@Then("^member has (\\d+) mile balance$")
	public void member_has_mile_balance(int balance) throws Throwable {
	    assertEquals(balance, member.getBalance());
	}

	/*
	@Given("^a flyer with username \"([^\"]*)\" and email \"([^\"]*)\" registers$")
	public void a_flyer_with_username_and_email_registers(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	*/
	
	@Then("^error \"([^\"]*)\" is returned$")
	public void error_is_returned(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
