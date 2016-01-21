package com.tddair;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.tddair.constants.Status;
import com.tddair.exceptions.DuplicateUserNameException;
import com.tddair.services.exceptions.CardDeclinedException;
import com.tddair.services.impl.FakeCreditCardProcessor;

public class WhenPurchasingSeatUpdates {
	
	private TddAirApplication app;
	private FakeCreditCardProcessor ccProcessor;

	@Before
	public void setup() throws Exception {
		this.app = new TddAirApplication();
		
		final Member test1 = new Member("test1", "test1@example.com", Status.RED, 0, 0);
		
		this.ccProcessor = new FakeCreditCardProcessor();
		test1.setCreditCardProcessor(this.ccProcessor);
		
		app.getMemberDAO().add(test1);
	}
	
	@Test
	public void shouldPurchaseUpgradesWithBalance() {
		fail("Not yet implemented");
	}
	
	@Test
	public void shouldPurchaseThreeUpgradesWithBalance() {
		
	}
	
	@Test
	public void shouldNotPurchaseUpdatesWithInsufficientBalance() {
		fail("Not yet implemented");
	}

	@Test
	public void shouldPurchaseUpgradeWithCC() {
		final Member test1 = app.lookUpMember("test1");
		test1.purchaseUpgradeWithCreditCard(1, "1111222233334444");
	}
	
	@Test(expected=CardDeclinedException.class)
	public void shouldPurchaseUpgradeWithCCAndGetDeclined() {
		// $1.00 is lower than fees, regardless of level
		this.ccProcessor.setChargeLimit(1.00);
		
		final Member test1 = app.lookUpMember("test1");
		test1.purchaseUpgradeWithCreditCard(1, "1111222233334444");
	}
	
	@Test
	public void shouldNotPurchaseUpgradeWithInvalidCC() {
		fail("Not yet implemented");
	}
}
