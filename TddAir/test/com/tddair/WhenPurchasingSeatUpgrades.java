package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
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
	
	@Test(expected=InsuffiecentMilesException.class)
	public void shouldNotPurchaseUpgradeWithInsufficientMiles() {
		member.setMilesBalance(5000);
		member.setStatus(Status.Blue);
		member.purchaseUpgrade(1);
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
	
	@Test(expected=InvalidCreditCardNumberException.class)
	public void shouldNotPurchaseUpgradeWithInvalidCreditCard() {
		CreditSystem credsys = new CreditSystemSpy(2500);
		member.setCreditSystem(credsys);
		member.setStatus(Status.Blue);
		
		member.purchaseUpgrade(1, "1234");
	}
	
	@Test(expected=InsuffiecentAvailableBalanceException.class)
	public void shouldNotPurchaseUpgradeWithInsufficientAvailableCredit() {
		CreditSystem credsys = new CreditSystemSpy(500);
		member.setCreditSystem(credsys);
		member.setStatus(Status.Red);
		
		member.purchaseUpgrade(1000, "123456789875216");
	}

}
