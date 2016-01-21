package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenPurchasingSeatUpgrades {
	
	private Member member;

	@Before
	public void setup() {
		member = new Member("bob", "bob@bob.com");
	}

	@Test
	public void shouldPurchaseUpgradeWithMiles() {
		member.setMilesBalance(19000);
		member.setStatus(Status.Green);
		
		member.purchaseUpgrade(1);
		
		assertEquals(10000, member.getMilesBalance());
		assertEquals(1, member.getUpgrades());
	}
	
	@Test
	public void shouldPurchaseThreeUpgradesWithMiles() {
		member.setMilesBalance(50000);
		member.setStatus(Status.Blue);
		
		member.purchaseUpgrade(3);
		
		assertEquals(26000, member.getMilesBalance());
		assertEquals(3, member.getUpgrades());
	}
	
	@Test
	public void shouldNotPurchaseUpgradeWithInsufficientMiles() {
		try {
			member.setMilesBalance(5000);
			member.setStatus(Status.Blue);
			member.purchaseUpgrade(1);
		} catch (Exception e) {
			assertEquals(InsuffiecentMilesException.class.getName(), e.getClass().getName());
			assertEquals(0, member.getUpgrades());
			assertEquals(5000, member.getMilesBalance());
		}
	}
	
	@Test
	public void shouldPurchaseUpgradeWithCreditCard() {
		CreditSystem credsys = new CreditSystemSpy(2500);
		member.setCreditSystem(credsys);
		member.setMilesBalance(10000);
		member.setStatus(Status.Blue);
		
		member.purchaseUpgrade(1, "1234567898745632");
		
		assertEquals(10000, member.getMilesBalance());
		assertEquals(1, member.getUpgrades());
		assertEquals(75, credsys.getAmountProcessed());
		assertEquals(2425, credsys.getAvailableBalance());
	}
	
	@Test
	public void shouldPurchaseMulitpleUpgradesWithCreditCard() {
		CreditSystem credsys = new CreditSystemSpy(2500);
		member.setCreditSystem(credsys);
		member.setMilesBalance(10000);
		member.setStatus(Status.Blue);
		
		member.purchaseUpgrade(10, "1234567898745632");
		
		assertEquals(10000, member.getMilesBalance());
		assertEquals(10, member.getUpgrades());
		assertEquals(750, credsys.getAmountProcessed());
		assertEquals(1750, credsys.getAvailableBalance());
	}
	
	@Test
	public void shouldNotPurchaseUpgradeWithInvalidCreditCard() {
		CreditSystem credsys = null;
		try {
			credsys = new CreditSystemSpy(2500);
			member.setCreditSystem(credsys);
			member.setStatus(Status.Blue);
			
			member.purchaseUpgrade(1, "1234");
		} catch (Exception e) {
			assertEquals(InvalidCreditCardNumberException.class.getName(), e.getClass().getName());
			assertEquals(0, member.getUpgrades());
			assertEquals(10000, member.getMilesBalance());
			assertEquals(0, credsys.getAmountProcessed());
			assertEquals(2500, credsys.getAvailableBalance());
		}
	}
	
	@Test
	public void shouldNotPurchaseUpgradeWithInsufficientAvailableCredit() {
		CreditSystem credsys = null;
		try {
			credsys = new CreditSystemSpy(2500);
			member.setCreditSystem(credsys);
			member.setStatus(Status.Red);
			
			member.purchaseUpgrade(1000, "123456789875216");
		} catch (Exception e) {
			assertEquals(InsuffiecentAvailableBalanceException.class.getName(), e.getClass().getName());
			assertEquals(0, member.getUpgrades());
			assertEquals(10000, member.getMilesBalance());
			assertEquals(0, credsys.getAmountProcessed());
			assertEquals(2500, credsys.getAvailableBalance());
		}
	}

}
