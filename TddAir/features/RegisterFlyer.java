import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.tddair.Flyer;
import com.tddair.TddAirApplication;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterFlyer {

	private TddAirApplication app = new TddAirApplication();
	private Flyer memberUnderTest;
	private Exception errorCondition;

	@When("^a customer registers and chooses username \"([^\"]*)\" and provides email address \"([^\"]*)\"$")
	public void a_customer_registers_and_chooses_username_and_provides_email_address(String arg1, String arg2)
			throws Throwable {
		memberUnderTest = new Flyer(arg1, arg2);

		try {
			app.registerNewFlyer(memberUnderTest);
		} catch (Exception e) {
			errorCondition = e;
		}
	}

	@Then("^the customer is added as a Flyer$")
	public void the_customer_is_added_as_a_Flyer() throws Throwable {
		assertNotNull(app.getFlyer(memberUnderTest.getUsername()));
	}

	@Then("^Flyer has \"([^\"]*)\" status$")
	public void flyer_has_status(String arg1) throws Throwable {
		assertEquals(arg1, memberUnderTest.getStatus());
	}

	@Then("^Flyer has (\\d+) ytdMiles$")
	public void flyer_has_ytdMiles(int arg1) throws Throwable {
		assertEquals(arg1, memberUnderTest.getYtdMiles());
	}

	@Then("^Flyer has (\\d+) mile balance$")
	public void flyer_has_mile_balance(int arg1) throws Throwable {
		assertEquals(arg1, memberUnderTest.getBalance());
	}

	@Then("^error \"([^\"]*)\" is returned$")
	public void error_is_returned(String errorMsg) throws Throwable {
		assertEquals(errorMsg, errorCondition.getMessage());
	}

	@Then("^no error is returned$")
	public void no_error_is_returned() throws Throwable {
		assertNull(errorCondition);
	}

}
