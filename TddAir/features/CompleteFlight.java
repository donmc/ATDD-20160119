import com.tddair.Flyer;
import com.tddair.TddAirApplication;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CompleteFlight {

	TddAirApplication app = StaticAppUtil.app;
	Flyer memberUnderTest;

	@Given("^a Flyer with username \"([^\"]*)\" and email \"([^\"]*)\" has booked a flight with status \"([^\"]*)\" and ytdMiles (\\d+)$")
	public void a_Flyer_with_username_and_email_has_booked_a_flight_with_status_and_ytdMiles(String username,
			String email, String arg3, int miles) throws Throwable {
		memberUnderTest = new Flyer(username, email);
		memberUnderTest.setYtdMiles(miles);
		app.registerNewFlyer(memberUnderTest);

	}

	@When("^the flyer completes flight \"([^\"]*)\"$")
	public void the_flyer_completes_flight(String flight) throws Throwable {
		memberUnderTest.completeFlight(app.getFlight(flight));
		app.updateMember(memberUnderTest);
	}

}
