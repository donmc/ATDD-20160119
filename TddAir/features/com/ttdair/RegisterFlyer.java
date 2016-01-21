package com.ttdair;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.tddair.Member;
import com.tddair.MemberDB;
import com.tddair.TddAirApplication;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterFlyer {
	
	private Exception exception = null; 
	
	@When("^a flyer with username \"([^\"]*)\" and email \"([^\"]*)\" register$")
	public void a_flyer_with_username_and_email_register(String arg1, String arg2) throws Throwable {
		TddAirApplication app = new TddAirApplication();
		try {
			app.registerAsMember(arg1, arg2);
		} catch (Exception e) {
			// No exception expected
			exception = e;
		}
	}

	@Then("^system has user with username \"([^\"]*)\"$")
	public void system_has_user_with_username(String arg1) throws Throwable {
		Member member = MemberDB.getMemberDB().getMember(arg1);
		assertNotNull(member);
		assertEquals(arg1, member.getUserName());  
	}

	@Then("^error \"([^\"]*)\" is returned$")
	public void error_is_returned(String arg1) throws Throwable {
		assertNotNull(exception);
		assertEquals(arg1, exception.getMessage());     
	    
	}
	
	@Then("^display error \"([^\"]*)\"$")
	public void display_error(String arg1) throws Throwable {
		assertEquals(arg1, exception.getMessage());     
	}

}
