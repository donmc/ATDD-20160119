package feature.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.tddair.Member;
import com.tddair.MemberDAO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationSteps {
	private MemberDAO memberDAO = new MemberDAO();
	
	/** Member for current test */
	private Member member;
	
	@Given("^existing members$")
	public void existing_members(final List<Member> membersTable) throws Throwable {
	    this.memberDAO.addAll(membersTable);
	}
	
	@Given("^a flyer with the username \"([^\"]*)\"$")
	public void setUserName(final String userName) {
		initMember();
		this.member.setUserName(userName);
		
	}
	
	@Given("^the flyer has email address \"([^\"]*)\"$")
	public void emailAddress(final String emailAddress) throws Throwable {
		initMember();
		this.member.setEmailAddress(emailAddress);
	}
	
	@When("^the flyer sumbits the registration form$")
	public void the_flyer_sumbits_the_registration_form() throws Throwable {
	    // TODO: Stub
	}
	
	@Then("^a member record is created in the database$")
	public void createRecord() throws Throwable {
	    this.memberDAO.add(this.member);
	}

	@Then("^the status for that member is \"([^\"]*)\"$")
	public void testMemberStatus(final String expectedStatus) throws Throwable {
		assertEquals("Initial status should be " + expectedStatus, 
				expectedStatus, this.member.getStatus());
	}

	@Then("^the balance for that member is (\\d+) miles$")
	public void testMemberTotalBalance(final int expectedTotalBalance) throws Throwable {
	    assertEquals("Initial balance should be " + expectedTotalBalance, 
	    		expectedTotalBalance, this.member.getTotalBalance());
	}

	@Then("^the YTD balance for that member is (\\d+) miles$")
	public void testMemberYTDBalance(final int expectedYTDBalance) throws Throwable {
		assertEquals("YTD balance should be " + expectedYTDBalance, 
				expectedYTDBalance, this.member.getYtdBalance());
	}

	@Given("^the user name is available$")
	public void userNameIsAvailable() throws Throwable {
	    final String userName = this.member.getUserName();
	    
		assertFalse("DB should not contain user name " + userName, 
	    		this.memberDAO.hasMemberWithUserName(userName));
	}
	
	@Given("^the flyer's user name already used by another registered member$")
	public void userNameIsUsed() throws Throwable {
		final String userName = this.member.getUserName();
	    
		assertTrue("DB should contain user name " + userName, 
	    		this.memberDAO.hasMemberWithUserName(userName));
	}

	@Given("^the flyer's email address already used by another registered member$")
	public void emailAddressIsUsed() throws Throwable {
	    final String emailAddress = this.member.getEmailAddress();
	    
		assertTrue("DB should contain email address " + emailAddress, 
	    		this.memberDAO.hasMemberWithEmailAddress(emailAddress));
	}
	
	
	// UTILITY METHODS
	protected void initMember() {
		if(null == this.member) {
			this.member = new Member();
		}
	}
}
