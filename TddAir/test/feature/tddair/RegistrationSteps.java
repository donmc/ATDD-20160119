package feature.tddair;

import static org.junit.Assert.*;


import java.util.List;

import com.tddair.Member;
import com.tddair.exceptions.DuplicateUserNameException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationSteps {
	private int numMembersBeforeRegistrationSubmitted = 0;
	private Exception registrationSubmitException = null;
	private String userName;
	private String emailAddress;
	
	@Given("^existing members$")
	public void existing_members(final List<Member> membersTable) throws Throwable {
	    StepData.getMemberDAO().addAll(membersTable);
	}
	
	@Given("^a flyer with the username \"([^\"]*)\" and the email address \"([^\"]*)\"$")
	public void setUserName(final String userName, final String emailAddress) {
		this.userName = userName;
		this.emailAddress = emailAddress;
	}
	
	@When("^the flyer sumbits the registration form$")
	public void the_flyer_sumbits_the_registration_form() throws Throwable {
	    try {
	    	this.numMembersBeforeRegistrationSubmitted = StepData.getMemberDAO().getNumMembers();
	    	
	    	final Member newMember = new Member(this.userName, this.emailAddress);
			StepData.getMemberDAO().add(newMember);
		} catch (final Exception e) {
			this.registrationSubmitException = e;
		}
	}
	
	@Then("^a member record is created in the database$")
	public void createRecord() throws Throwable {
		assertNull("Error occurred during registration", this.registrationSubmitException);
		assertEquals("Member record was not created", 
				StepData.getMemberDAO().getNumMembers(), this.numMembersBeforeRegistrationSubmitted + 1);
	}

	@Then("^the status for \"([^\"]*)\" is \"([^\"]*)\"$")
	public void testMemberStatus(final String userName, final String expectedStatus) throws Throwable {
		final Member member = StepData.getMemberDAO().getMemberByUserName(userName);
		assertEquals("Initial status should be " + expectedStatus, 
				expectedStatus, member.getStatus());
	}

	@Then("^the reward balance for \"([^\"]*)\" is (\\d+) miles$")
	public void testMemberTotalBalance(final String userName, final int expectedTotalBalance) throws Throwable {
		final Member member = StepData.getMemberDAO().getMemberByUserName(userName);
		assertEquals("Initial balance should be " + expectedTotalBalance, 
	    		expectedTotalBalance, member.getRewardBalance());
	}

	@Then("^the YTD balance for \"([^\"]*)\" is (\\d+) miles$")
	public void testMemberYTDBalance(final String userName, final int expectedYTDBalance) throws Throwable {
		final Member member = StepData.getMemberDAO().getMemberByUserName(userName);
		assertEquals("YTD balance should be " + expectedYTDBalance, 
				expectedYTDBalance, member.getYtdBalance());
	}
	
	@Then("^a \"([^\"]*)\" error message is displayed$")
	public void an_error_message_is_displayed(final String errorType) throws Throwable {
		assertNotNull("A error was expected", 
				this.registrationSubmitException);
		
		Class<?> expectedErrorType = Exception.class;
		switch(errorType) {
		case "duplicate user name":
			expectedErrorType = DuplicateUserNameException.class;
			break;
		}
		
		final boolean errorIsProperType = 
			expectedErrorType.isAssignableFrom(this.registrationSubmitException.getClass());
		assertTrue("Error was of wrong type", errorIsProperType);
	}
}
