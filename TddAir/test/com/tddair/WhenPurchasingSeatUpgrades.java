package com.tddair;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class WhenPurchasingSeatUpgrades {

	private Member purchaser;
	private CASSpy spyCAS;

	@Test
	public void shouldPurchaseUpgradeWithMiles_Red() {
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
	
	@Test
	public void shouldPurchaseUpgradeWithMiles_Blue() {
		setUpMember(Category.Blue, 9000);
		int purchasedUpgrades = purchaser.purchaseUpgradeWithMiles(1);
		assertEquals(1, purchasedUpgrades);
		assertEquals(new Integer(1000), purchaser.getMilesBalance());
		assertEquals(new Integer(1), purchaser.getUpgrades());
		assertEquals(Category.Blue, purchaser.getStatus());
	}
	
	@Test
	public void shouldPurchaseUpgradeWithMiles_Golden() {
		setUpMember(Category.Golden, 9000);
		int purchasedUpgrades = purchaser.purchaseUpgradeWithMiles(1);
		assertEquals(1, purchasedUpgrades);
		assertEquals(new Integer(2000), purchaser.getMilesBalance());
		assertEquals(new Integer(1), purchaser.getUpgrades());
		assertEquals(Category.Golden, purchaser.getStatus());
	}
		
	@Test
	public void shouldPurchaseanUpgradeWithCreditCard_Red() {
		setUpMember(Category.Red, 11000);
		purchaser.purchaseUpgradeWithCreditCard(1, "9999111155558888");
		assertEquals(new Integer(11000), purchaser.getMilesBalance());
		assertEquals(new Integer(1), purchaser.getUpgrades());
		assertEquals(100, spyCAS.getTotalAmount());
		assertEquals(1, spyCAS.getCountApprovedCalled());
	}
	

	@Test
	public void shouldNotPurchaseanUpgradeWithInvalidCreditCard() {
		setUpMember(Category.Red, 11000);
		purchaser.purchaseUpgradeWithCreditCard(1, "9BSVCdfds8");
		assertEquals(new Integer(11000), purchaser.getMilesBalance());
		assertEquals(new Integer(0), purchaser.getUpgrades());
		assertEquals(0, spyCAS.getTotalAmount());
		assertEquals(1, spyCAS.getCountApprovedCalled());
	}
	
	private void setUpMember(Category status, int milesBalance)
	{
		spyCAS = new CASSpy();
		purchaser = new Member("JoBob");
		purchaser.setStatus(status);
		purchaser.setMilesBalance(milesBalance);
		purchaser.setCreditCardSystem(spyCAS);
	}
}
