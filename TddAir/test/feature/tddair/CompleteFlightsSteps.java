package feature.tddair;

import com.tddair.Member;
import com.tddair.TddAirApplication;

import cucumber.api.java.en.When;

public class CompleteFlightsSteps {
	@When("^\"([^\"]*)\" completes flight \"([^\"]*)\"$")
	public void userCompletesFlight(final String userName, final String flightNumber) throws Throwable {
	    final TddAirApplication app = StepData.getApplication();
		
		final Member member = app.lookUpMember(userName);
	    app.completeFlight(member, flightNumber);
	}
}
