package com.tddair.features;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisteredFlyer {

@When("^a flyer with username \"([^\"]*)\" and email \"([^\"]*)\" registers$")
public void a_flyer_with_username_and_email_registers(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^system has user with username \"([^\"]*)\"$")
public void system_has_user_with_username(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^member has \"([^\"]*)\" status$")
public void member_has_status(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^member has (\\d+) ytdmiles$")
public void member_has_ytdmiles(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^member has (\\d+) mile balance$")
public void member_has_mile_balance(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^error \"([^\"]*)\" is returned$")
public void error_is_returned(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}
}
