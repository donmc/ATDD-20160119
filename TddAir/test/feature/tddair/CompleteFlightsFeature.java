package feature.tddair;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"features/complete_flights.feature"}, 
		plugin = {"pretty"}, 
		monochrome = true)
public class CompleteFlightsFeature {
}
