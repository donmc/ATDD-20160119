package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

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
		member.completeFlight(new Flight("ABC", "DEF", 20000, "AA", 123));
		int expectedBalance = member.getBalance() - 30000;
		boolean purchaseStatus = member.purchaseUpgradeWithMiles(3);
		
		
		assertEquals(member.getUpgradeCount(), 3);
		assertEquals(member.getBalance(), expectedBalance);
		assertTrue(purchaseStatus);
	}
	
	
	@Test
	public void shouldNotPurchaseUpgradesWithInsufficientMiles() {
		int expectedBalance = member.getBalance();
		boolean purchaseStatus = member.purchaseUpgradeWithMiles(3);
		
		
		assertEquals(member.getUpgradeCount(), 0);
		assertEquals(member.getBalance(), expectedBalance);
		assertFalse(purchaseStatus);
	}
	
	@Test
	public void shouldPurchaseUpgradeWithCC() {
		/*CAS spy = new CASSpy();
		member.setCreditAuthroizationSystem(spy);*/
		boolean purchasedUpgrade = member.purchaseUpgradeWithCC(1, "1234567890123456");
		
		
		assertEquals(member.getUpgradeCount(), 1);
		assertTrue(purchasedUpgrade);
		
		CAS spy = TransactionProcessor.getInstance();
		assertEquals(spy.getTransactionCount(), 1);
		assertEquals(spy.getTransactionCost(), BigDecimal.valueOf(100));
	}
	
	@Test
	public void shouldNotPurchaseUpgradeWithInvalidCC() {
		/*CAS spy = new CASSpy();
		member.setCreditAuthroizationSystem(spy);*/
		boolean purchasedUpgrade = member.purchaseUpgradeWithCC(1, "12345678901234");
		
		
		assertEquals(member.getUpgradeCount(), 0);
		assertFalse(purchasedUpgrade);
		
		CAS spy = TransactionProcessor.getInstance();
		assertEquals(spy.getTransactionCount(), 0);
		assertEquals(spy.getTransactionCost(), BigDecimal.ZERO);
	}
}
