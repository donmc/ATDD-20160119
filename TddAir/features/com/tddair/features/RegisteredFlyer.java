package com.tddair.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisteredFlyer {

	private CucumberSharedDataHolder dataHolder;

	public RegisteredFlyer() {
		super();
		dataHolder = CucumberSharedDataHolder.getInstance();
	}

	@When("^a flyer with username \"([^\"]*)\" and email \"([^\"]*)\" registers$")
	public void a_flyer_with_username_and_email_registers(String userName, String email) {
		// Write code here that turns the phrase above into concrete actions
		try {
			dataHolder.getApp().registerAsMember(userName, email);
		}
		catch (IllegalArgumentException e)
		{
			dataHolder.setExceptionMessage(e.getMessage());
		}
	}

	@Then("^system has user with username \"([^\"]*)\"$")
	public void system_has_user_with_username(String userName) {
		// Write code here that turns the phrase above into concrete actions
		dataHolder.setMember1(dataHolder.getApp().lookUpMember(userName));
		assertNotNull(dataHolder.getMember1());
	}

	@Then("^member has \"([^\"]*)\" status$")
	public void member_has_status(String category){
		// Write code here that turns the phrase above into concrete actions
		assertEquals(category, dataHolder.getMember1().getStatus().name());

	}

	@Then("^member has (\\d+) ytdmiles$")
	public void member_has_ytdmiles(Integer miles){
		// Write code here that turns the phrase above into concrete actions
		assertEquals(miles, dataHolder.getMember1().getYtdMiles());
	}

	@Then("^member has (\\d+) mile balance$")
	public void member_has_mile_balance(Integer milesBalance){
		// Write code here that turns the phrase above into concrete actions
		assertEquals(milesBalance, dataHolder.getMember1().getMilesBalance());
	}

	@Then("^error \"([^\"]*)\" is returned$")
	public void error_is_returned(String error) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(error, dataHolder.getDuplicateMessage());
	}
}
