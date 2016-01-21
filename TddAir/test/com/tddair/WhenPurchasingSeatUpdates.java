package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.tddair.constants.Status;
import com.tddair.exceptions.DuplicateUserNameException;
import com.tddair.exceptions.InsufficientBalanceException;
import com.tddair.services.exceptions.CardDeclinedException;
import com.tddair.services.impl.FakeCreditCardProcessor;

public class WhenPurchasingSeatUpdates {
	private TddAirApplication app;
	private FakeCreditCardProcessor ccProcessor;

	@Before
	public void setup() throws Exception {
		this.app = new TddAirApplication();
		
		final Member newRedMember = new Member("newRedMember", "red@example.com", Status.RED, 0, 0);
		
		this.ccProcessor = new FakeCreditCardProcessor();
		newRedMember.setCreditCardProcessor(this.ccProcessor);
		
		app.getMemberDAO().add(newRedMember);
	}
	
	@Test
	public void shouldPurchaseUpgradesWithBalance() throws Exception {
		final int startingBalance = 10000;
		final Member redMember = new Member("redMember", "red@example.com", 
				Status.RED, startingBalance, 0);
		
		redMember.purchaseUpgrade(1);
		final int endingBalance = redMember.getRewardBalance();
		assertEquals("Member was charged the wrong number of points", 
				endingBalance, 0);
	}
	
	@Test
	public void shouldPurchaseThreeUpgradesWithBalance() throws InsufficientBalanceException {
		final int startingBalance = 30000;
		final Member redMember = new Member("redMember", "red@example.com", 
				Status.RED, startingBalance, 0);
		
		redMember.purchaseUpgrade(3);
	}
	
	@Test(expected=InsufficientBalanceException.class)
	public void shouldNotPurchaseUpdatesWithInsufficientBalance() throws Exception {
		final int startingBalance = 9999;
		final Member redMember = new Member("redMember", "red@example.com", 
				Status.RED, startingBalance, 0);
		
		redMember.purchaseUpgrade(1);
	}
	
	@Test
	public void failedPurchaseShouldNotDeductPoints() throws Exception {
		final int startingBalance = 9999;
		final Member redMember = new Member("redMember", "red@example.com", 
				Status.RED, startingBalance, 0);
		
		boolean threwException = false;
		try {
			redMember.purchaseUpgrade(1);
		} catch (Exception e) {
			threwException = true;
		}
		assertTrue("Purchase should have failed", threwException);
		
		assertEquals("Member should not have been charged reward miles", 
				redMember.getRewardBalance(), startingBalance);
	}
	

	@Test
	public void shouldPurchaseUpgradeWithCC() throws Exception {
		// $100.00 is the cost of RED fees
		this.ccProcessor.setChargeLimit(100.00);
		
		final Member redMember = app.lookUpMember("newRedMember");
		redMember.purchaseUpgradeWithCreditCard(1, "1111222233334444");
	}
	
	@Test(expected=CardDeclinedException.class)
	public void shouldPurchaseUpgradeWithCCAndGetDeclined() throws CardDeclinedException {
		// $1.00 is lower than fees, regardless of level
		this.ccProcessor.setChargeLimit(1.00);
		
		final Member redMember = app.lookUpMember("newRedMember");
		redMember.purchaseUpgradeWithCreditCard(1, "1111222233334444");
	}
	
	@Test(expected=CardDeclinedException.class)
	public void shouldNotPurchaseUpgradeWithInvalidCC() throws CardDeclinedException {
		// $100.00 is the cost of RED fees
		this.ccProcessor.setChargeLimit(100.00);
		
		final Member redMember = app.lookUpMember("newRedMember");
		redMember.purchaseUpgradeWithCreditCard(3, "1111222233334444");
	}
}
