package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenPurchasingSeatUpgrades {
	
	private Member member;

	@Before
	public void setup()
	{
		member = new Member("martymc", "email@email.com");
	}

	@Test
	public void shouldPurchaseUpgradeWithMilesAndRedStatus() {
		int expectedBalance = member.getBalance() - 10000;
		boolean purchaseStatus = member.purchaseUpgradeWithMiles(1);
		
		
		assertEquals(member.getUpgradeCount(), 1);
		assertEquals(member.getBalance(), expectedBalance);
		assertTrue(purchaseStatus);
	}
	
	@Test
	public void shouldPurchaseThreeUpgradesWithMiles() {
		int expectedBalance = member.getBalance() - 30000;
		boolean purchaseStatus = member.purchaseUpgradeWithMiles(3);
		
		
		assertEquals(member.getUpgradeCount(), 3);
		assertEquals(member.getBalance(), expectedBalance);
		assertTrue(purchaseStatus);
	}
	
	
	@Ignore
	@Test
	public void shouldNotPurchaseUpgradesWithInsufficientMiles() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldPurchaseUpgradeWithCC() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldNotPurchaseUpgradeWithInvalidCC() {
		fail("Not yet implemented");
	}
}
