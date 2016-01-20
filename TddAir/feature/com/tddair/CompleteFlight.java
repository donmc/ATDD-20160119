package com.tddair;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompleteFlight {
	private Flight flight;
	private Member member;
	
	@Given("^a member with (\\d+) YtdMiles and \"([^\"]*)\" status$")
	public void a_member_with_YtdMiles_and_status(int arg1, String arg2) throws Throwable {
		member = new Member("donmc", "don@gmail.com");
		member.setYtdMiles(arg1);
		member.setStatus(Status.valueOf(arg2));
	}

	@When("^member completes an (\\d+) mile flight$")
	public void member_completes_an_mile_flight(int arg1) throws Throwable {
		flight = new Flight("DFW", "ORD", arg1, "AA", 1234);
		member.completeFlight(flight);
	}

	@Then("^member will have \"([^\"]*)\" status\\.$")
	public void member_will_have_status(String arg1) throws Throwable {
		assertEquals(member.getStatus(), Status.valueOf(arg1));
	}
}
