package com.tddair.features;

import com.tddair.Member;
import com.tddair.TddAirApplication;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

import java.util.Locale.Category;

public class RegisteredFlyer {

	private TddAirApplication app;
	private Member member1;

	public RegisteredFlyer() {
		super();
		app = new TddAirApplication();
	}

	@When("^a flyer with username \"([^\"]*)\" and email \"([^\"]*)\" registers$")
	public void a_flyer_with_username_and_email_registers(String userName, String email) {
		// Write code here that turns the phrase above into concrete actions
		app.registerAsMember(userName, email);
	}

	@Then("^system has user with username \"([^\"]*)\"$")
	public void system_has_user_with_username(String userName) {
		// Write code here that turns the phrase above into concrete actions
		member1 = app.lookUpMember(userName);
		assertNotNull(member1);
	}

	@Then("^member has \"([^\"]*)\" status$")
	public void member_has_status(String category){
		// Write code here that turns the phrase above into concrete actions
		assertEquals(category, member1.getStatus().name());

	}

	@Then("^member has (\\d+) ytdmiles$")
	public void member_has_ytdmiles(Integer miles){
		// Write code here that turns the phrase above into concrete actions
		assertEquals(miles, member1.getYtdMiles());
	}

	@Then("^member has (\\d+) mile balance$")
	public void member_has_mile_balance(Integer milesBalance){
		// Write code here that turns the phrase above into concrete actions
		assertEquals(milesBalance, member1.getMilesBalance());
	}

	@Then("^error \"([^\"]*)\" is returned$")
	public void error_is_returned(String error) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}
}
