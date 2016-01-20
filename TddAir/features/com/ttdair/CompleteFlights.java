package com.ttdair;

import com.tddair.Member;
import com.tddair.MemberStatus;
import com.tddair.TddAirApplication;
import com.ttdair.helper.TddApplicationHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CompleteFlights {

	private TddAirApplication app = TddApplicationHelper.retrieveTddApp();
	
	@Given("^a \"([^\"]*)\" member \"([^\"]*)\" with (\\d+) YTD milage$")
	public void a_member_with_YTD_milage(MemberStatus arg1, String arg2, int arg3) throws Throwable {
	   
		app.registerAsMember(arg2, "email@yahoo.com");
		Member member = app.lookupMember(arg2);
		member.setStatus(arg1);
		member.setYtdMiles(arg3);
		member.setBalanceMiles(30000); 
		TddApplicationHelper.setMember(member);
	}

	@When("^member completes flight \"([^\"]*)\"$")
	public void member_completes_flight(String arg1) throws Throwable {
		Member member = TddApplicationHelper.getMember();
	    app.completeFlight(member.getUserName(), arg1); 
	}
}
