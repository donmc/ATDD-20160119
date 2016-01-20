import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.tddair.Flyer;
import com.tddair.TddAirApplication;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterFlyer {

	private static TddAirApplication app = StaticAppUtil.app;
	private Exception errorCondition;

	@When("^a customer registers and chooses username \"([^\"]*)\" and provides email address \"([^\"]*)\"$")
	public void a_customer_registers_and_chooses_username_and_provides_email_address(String arg1, String arg2)
			throws Throwable {
		Flyer memberUnderTest = new Flyer(arg1, arg2);

		try {
			app.registerNewFlyer(memberUnderTest);
		} catch (Exception e) {
			errorCondition = e;
		}
	}

	@Then("^the customer with username \"([^\"]*)\" is added as a Flyer$")
	public void the_customer_with_username_is_added_as_a_Flyer(String username) throws Throwable {
		assertNotNull(app.getFlyer(username));
	}

	@Then("^Flyer with username \"([^\"]*)\" has \"([^\"]*)\" status$")
	public void flyer_with_username_has_status(String username, String status) throws Throwable {
		assertEquals(app.getFlyer(username).getStatus(), status);
	}

	@Then("^Flyer with username \"([^\"]*)\" has (\\d+) ytdMiles$")
	public void flyer_with_username_has_ytdMiles(String username, int ytdMiles) throws Throwable {
		assertEquals(ytdMiles, app.getFlyer(username).getYtdMiles());
	}

	@Then("^Flyer with username \"([^\"]*)\" has (\\d+) mile balance$")
	public void flyer_with_username_has_mile_balance(String username, int balance) throws Throwable {
		assertEquals(balance, app.getFlyer(username).getBalance());
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
