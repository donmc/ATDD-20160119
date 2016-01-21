package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WhenPurchasingSeatUpgrades {

	protected CreditAuthorizationSpy thingy = new CreditAuthorizationSpy();
	protected String validCC = "1234000045672222";
	protected String invalidCC = "1234000045672222";

	@Test
	public void shouldPurchaseUpgradesWithMiles() {
		Member member = new Member("raquel", "boss@raquelville.com");
		member.completeFlight(new Flight("DFW", "SAN", 10000, "AA", 1234));
		assertEquals(2, member.purchaseUpgradesWithMiles(2));
	}

	@Test
	public void shouldNotPurchaseUpgradewsWithInsufficientMiles() {
		Member member = new Member("raquel", "boss@raquelville.com");
		member.completeFlight(new Flight("DFW", "SAN", 300, "AA", 1234));
		assertEquals(0, member.purchaseUpgradesWithMiles(2));
	}
	
	@Test
	public void shouldPurchaseUpgradeWithCreditCard() {
		Member member = new Member("raquel", "boss@raquelville.com");
		thingy.addCard(validCC, 10000.00);
		assertEquals(2, member.purchaseUpgradesWithCreditCard(2, validCC, thingy));
	}
	
	@Test
	public void shouldNotPurchaseUpgradeWithInvalidCreditCard() {
		Member member = new Member("raquel", "boss@raquelville.com");
		assertEquals(0, member.purchaseUpgradesWithCreditCard(2, invalidCC, thingy));
	}
	
	@Test
	public void shouldHaveCalledCreditAuth() {
		Member member = new Member("raquel", "boss@raquelville.com");
		thingy.addCard(validCC, 10000.00);
		member.purchaseUpgradesWithCreditCard(2, validCC, thingy);
		member.purchaseUpgradesWithCreditCard(2, validCC, thingy);
		assertEquals(2, thingy.authCounterSpy);
	}
	
}
