package com.tddair.features;

import static org.junit.Assert.assertEquals;

import com.tddair.Member;
import com.tddair.Status;
import com.tddair.TddAirApplication;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompleteFlights {
	
	TddAirApplication app = TddSingleton.getTddAirApp();
	Member member;
	
	@Given("^a member with username \"([^\"]*)\"$")
	public void a_member_with_username(String arg1) throws Throwable {
		member = new Member(arg1, "bob@bob.com");
	}
	
	@Given("^currentYtdMileage is (\\d+)$")
	public void currentytdmileage_is(int arg1) throws Throwable {
		member.setYtdMiles(arg1);
	}

	@Given("^member is currently a \"([^\"]*)\" status$")
	public void member_is_currently_a_status(String arg1) throws Throwable {
		member.setStatus(Status.valueOf(arg1));
		
	}
	
	@When("^a member completes flight \"([^\"]*)\"$")
	public void a_member_completes_flight(String arg1) throws Throwable {
	  app.completeFlight(member, arg1);
	}
	
	@Then("^their member status is \"([^\"]*)\"$")
	public void their_member_status_is(String arg1) throws Throwable {
	   assertEquals(Status.valueOf(arg1), member.getStatus());
	}

}
