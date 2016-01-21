package com.tddair;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompletingFlightTest{
	private TddAirApplication app = new TddAirApplication();
	private Member member;
	
	

	@Given("^member is \"([^\"]*)\" status with (\\d+) ytdMiles and (\\d+) miles balance$")
	public void member_is_status_with_ytdMiles_and_miles_balance(Status status, int ytdMiles, int miles)
			throws Throwable {
		member = new Member("username", "email", status, ytdMiles, miles);
	}
	
	@When("^the member completes a flight of (\\d+) miles$")
	public void the_member_completes_a_flight_of_miles(int miles) throws Throwable {
		app.addFlight("aaa", "bbb", miles, "aa", 123);
		app.completeFlight(member, "aa123");
	}
	
	@Then("^member should have (\\d+) miles balance$")
	public void member_should_have_miles_balance(int miles) throws Throwable {
		assertEquals(miles, member.getMiles());
	}

	@Then("^member status should be \"([^\"]*)\"$")
	public void member_status_should_be(Status status) throws Throwable {
		assertEquals(status, member.getStatus());
	}

	@Then("^member should have (\\d+) ytdMiles$")
	public void member_should_have_ytdMiles(int ytdMiles) throws Throwable {
		assertEquals(ytdMiles, member.getYtdMiles());
	}

	

}
