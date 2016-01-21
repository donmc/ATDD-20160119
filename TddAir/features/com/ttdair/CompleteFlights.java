package com.ttdair;

import static org.junit.Assert.assertEquals;

import com.tddair.Member;
import com.tddair.MemberDB;
import com.tddair.MemberStatus;
import com.tddair.TddAirApplication;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompleteFlights {

	private TddAirApplication app = new TddAirApplication();
	
	@Given("^a \"([^\"]*)\" member \"([^\"]*)\" with (\\d+) YTD milage with (\\d+) miles balance$")
	public void a_member_with_YTD_milage_with_miles_balance(MemberStatus status, String username, int ytdMiles, int balance) throws Throwable {
		Member member = app.lookupMember(username);
		if (member == null) {
			app.registerAsMember(username, "email@yahoo.com");
			member = app.lookupMember(username);
		}
		member.setStatus(status);
		member.setYtdMiles(ytdMiles);
		member.setBalanceMiles(balance);
	}

	@When("^member \"([^\"]*)\" completes flight \"([^\"]*)\"$")
	public void member_completes_flight(String userName, String flightNumber) throws Throwable {
		
		app.completeFlight(MemberDB.getMemberDB().getMember(userName).getUserName(), flightNumber);
	}
	
	@Then("^member \"([^\"]*)\" has \"([^\"]*)\" status$")
	public void member_has_status(String userName, MemberStatus status) throws Throwable {
	    
		assertEquals(MemberDB.getMemberDB().getMember(userName).getStatus(), status);	
	}

	@Then("^member \"([^\"]*)\" has (\\d+) ytdMiles$")
	public void member_has_ytdMiles(String userName, int ytdMiles) throws Throwable {
		
		assertEquals(MemberDB.getMemberDB().getMember(userName).getYtdMiles(), ytdMiles);	
	}

	@Then("^member \"([^\"]*)\" has (\\d+) miles balance$")
	public void member_has_miles_balance(String userName, int balance) throws Throwable {
		
		assertEquals(MemberDB.getMemberDB().getMember(userName).getBalanceMiles(), balance);	
	}
}
