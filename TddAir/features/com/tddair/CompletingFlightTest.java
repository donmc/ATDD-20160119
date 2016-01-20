package com.tddair;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompletingFlightTest {
	private TddAirApplication app = new TddAirApplication();
	private Member member;
	
	@Given("^member is \"([^\"]*)\" status with (\\d+) ytdMiles and (\\d+) miles balance$")
	public void member_is_status_with_ytdMiles_and_miles_balance(Status status, int ytdMiles, int miles) throws Throwable {
		member = new Member("username", "email", status, ytdMiles, miles );
	}

	@When("^the member completes a flight of (\\d+) miles$")
	public void the_member_completes_a_flight_of_miles(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^member status should be \"([^\"]*)\"$")
	public void member_status_should_be(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^member should have (\\d+) ytdMiles$")
	public void member_should_have_ytdMiles(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^member should have (\\d+) miles balance$")
	public void member_should_have_miles_balance(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
