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
		assertEquals(new Integer(1), purchaser.getUpgrades());
	}

	@Test
	public void shouldPurchaseThreeUpgradesWithMiles() {
		setUpMember(Category.Red, 31000);
		int purchasedUpgrades = purchaser.purchaseUpgradeWithMiles(3);
		assertEquals(3, purchasedUpgrades);
		assertEquals(new Integer(1000), purchaser.getMilesBalance());
		assertEquals(new Integer(3), purchaser.getUpgrades());
	}
	
	@Test
	public void shouldNotPurchaseUpgradesWithInsufficientMiles() {
		setUpMember(Category.Red, 9000);
		int purchasedUpgrades = purchaser.purchaseUpgradeWithMiles(1);
		assertEquals(0, purchasedUpgrades);
		assertEquals(new Integer(9000), purchaser.getMilesBalance());
		assertEquals(new Integer(0), purchaser.getUpgrades());
	}
	
	@Test
	public void shouldPurchaseUpgradeWithMiles_Green() {
		setUpMember(Category.Green, 35000);
		int purchasedUpgrades = purchaser.purchaseUpgradeWithMiles(2);
		assertEquals(2, purchasedUpgrades);
		assertEquals(new Integer(17000), purchaser.getMilesBalance());
		assertEquals(new Integer(2), purchaser.getUpgrades());
		assertEquals(Category.Green, purchaser.getStatus());
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
