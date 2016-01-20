package com.tddair.features;

import static org.junit.Assert.assertEquals;

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
	public void a_member_with_ytdmiles(String arg1, String arg2, int arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@When("^member completes flight \"([^\"]*)\"$")
	public void member_completes_flight_Not_real_flight(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
