package com.tddair.features;

import static org.junit.Assert.*;

import com.tddair.DuplicateMemberException;
import com.tddair.Member;
import com.tddair.TddAirApplication;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterFlyer {

	TddAirApplication app = new TddAirApplication();
	Member member;
	Exception duplicateMemberException;

	@When("^a flyer with username \"([^\"]*)\" and email \"([^\"]*)\" registers$")
	public void a_flyer_with_username_and_email_registers(String arg1, String arg2) throws Throwable {
		try {
			app.registerAsMember(arg1, arg2);
		} catch (DuplicateMemberException e) {
			duplicateMemberException = e;
		}
	}

	@Then("^system has user with username \"([^\"]*)\"$")
	public void system_has_user_with_username(String arg1) throws Throwable {
		member = app.lookUpMember(arg1);
		assertEquals(arg1, member.getUserName());
	}

	@Then("^member has \"([^\"]*)\" status$")
	public void member_has_status(String arg1) throws Throwable {
		assertEquals(arg1, member.getStatus());
	}

	@Then("^member has (\\d+) ytdMiles$")
	public void member_has_ytdMiles(int arg1) throws Throwable {
		assertEquals(arg1, member.getYtdMiles());
	}

	@Then("^member has (\\d+) mile balance$")
	public void member_has_mile_balance(int arg1) throws Throwable {
		assertEquals(arg1, member.getMilesBalance());
	}

	@Then("^error \"([^\"]*)\" is returned$")
	public void error_is_returned(String arg1) throws Throwable {
		assertNotNull(duplicateMemberException);
		assertEquals(arg1, duplicateMemberException.getMessage());
	}

}
