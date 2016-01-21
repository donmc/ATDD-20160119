package com.tddair.features;

import static org.junit.Assert.assertEquals;

import com.tddair.Flight;
import com.tddair.Member;
import com.tddair.Status;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompleteFlight {
	
	private Member member;
	
	@Given("^a member \"([^\"]*)\" and \"([^\"]*)\" status and (\\d+) YTD miles$")
	public void a_member_and_status_and_YTD_miles(String username, String status, int ytdMiles) {
	    member = TddAirSingleton.getInstance().lookUp(username);
	    member.setYtdMiles(ytdMiles);
	    member.setStatus(Status.valueOf(status));
	}

	@When("^member \"([^\"]*)\" completes flight \"([^\"]*)\"$")
	public void member_completes_flight(String username, String fullFlightNumber) {
	    Flight flight = TddAirSingleton.getInstance().getFlight(fullFlightNumber);
		TddAirSingleton.getInstance().completeFlight(member, flight);
	}

	@Then("^member has status equal to \"([^\"]*)\"$")
	public void member_has_status_equal_to(String status) {
	    assertEquals(member.getStatus().name(), status);
	}

}
