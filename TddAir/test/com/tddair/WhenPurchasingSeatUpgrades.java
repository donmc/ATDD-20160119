package com.tddair;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class WhenPurchasingSeatUpgrades {

	private Member purchaser;
	
	@Test
	public void shouldPurchaseUpgradeWithMiles() {
		setUpMember(Category.Red, 11000);
		int purchasedUpgrades = purchaser.purchaseUpgradeWithMiles(1);
		assertEquals(1, purchasedUpgrades);
		assertEquals(new Integer(1000), purchaser.getMilesBalance());
	}

	@Ignore
	@Test
	public void shouldPurchaseThreeUpgradesWithMiles() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldNotPurchaseUpgradesWithInsufficientMiles() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldPurchaseanUpgradeWithCreditCard() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldNotPurchaseanUpgradeWithInvalidCreditCard() {
		fail("Not yet implemented");
	}
	
	private void setUpMember(Category status, int milesBalance)
	{
		purchaser = new Member("JoBob");
		purchaser.setStatus(status);
		purchaser.setMilesBalance(milesBalance);
	}
}
