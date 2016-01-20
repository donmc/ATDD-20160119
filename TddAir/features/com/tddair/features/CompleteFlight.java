package com.tddair.features;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompleteFlight {
	
	@Given("^a member \"([^\"]*)\" and \"([^\"]*)\" status and (\\d+) YTD miles$")
	public void a_member_and_status_and_YTD_miles(String username, String status, int ytdMiles) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^member \"([^\"]*)\" completes flight \"([^\"]*)\"$")
	public void member_completes_flight(String username, String fullFlightNumber) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^member has status equal to \"([^\"]*)\"$")
	public void member_has_status_equal_to(String status) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
