package com.tddair.features;

import static org.junit.Assert.assertEquals;

import com.tddair.Category;
import com.tddair.FlightNotFoundException;
import com.tddair.Member;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompleteFlight {
	
	private CucumberSharedDataHolder dataHolder;

	public CompleteFlight() {
		super();
		dataHolder = CucumberSharedDataHolder.getInstance();
	}

	@Given("^a \"([^\"]*)\" member \"([^\"]*)\" with (\\d+) ytdmiles$")
	public void a_member_with_ytdmiles(String status, String userName, int ytdMiles) {
	    // Write code here that turns the phrase above into concrete actions
	    dataHolder.setMember1(new Member(userName));
		dataHolder.getMember1().setStatus(Category.valueOf(status));
	    dataHolder.getMember1().setYtdMiles(ytdMiles);
	}
	
	@When("^member completes flight \"([^\"]*)\"$")
	public void member_completes_flight(String flightNumber) {
		try{
			dataHolder.getApp().completeFlight(flightNumber, dataHolder.getMember1());
		}
		catch(FlightNotFoundException exception)
		{
			dataHolder.setExceptionMessage(exception.getMessage());
		}
		
		
	}


}
