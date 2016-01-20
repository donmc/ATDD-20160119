package com.tddair;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class RegisterFlyerTest {
	private Member member;
	private TddAirApplication app = new TddAirApplication();
	private Exception exception;

	@When("^a flyer with username \"([^\"]*)\" and email \"([^\"]*)\" registers$")
	public void a_flyer_with_username_and_email_registers(String username, String email) throws Throwable {
		try
		{
			this.member = app.registerAsMember(username, email);
		} catch (Exception e){
			this.exception = e;
		}
	}

	@Then("^system has a member with username \"([^\"]*)\"$")
	public void system_has_a_member_with_username(String username) throws Throwable {
		assertNotNull(app.lookUpMember(username));
	}

	@Then("^member has \"([^\"]*)\" status$")
	public void member_has_status(Status status) throws Throwable {
		assertEquals(status, member.getStatus());
	}

	@Then("^member has (\\d+) ytdMiles$")
	public void member_has_ytdMiles(int ytdMiles) throws Throwable {
		assertEquals(ytdMiles, member.getYtdMiles());
	}

	@Then("^member has (\\d+) mile balance$")
	public void member_has_mile_balance(int miles) throws Throwable {
		assertEquals(miles, member.getMiles());
	}

	@Then("^return a failure message of \"([^\"]*)\"$")
	public void return_a_failure_message_of(String errorMessage) throws Throwable {
		assertNotNull(this.exception);
		assertEquals(errorMessage, this.exception.getMessage());
	}

}
