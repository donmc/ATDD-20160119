package com.tddair;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.tddair.exception.InsufficientFundException;
import com.tddair.exception.InvalidCCException;

public class WhenPurchasingSeatUpgrades {
	Member member = new Member("donmc", "email", Status.Red, 0, 30000);
	CASSpy cas = new CASSpy();
	
	@Test
	public void shouldPurchaseUpgradesWithMiles() {
		member.purchaseUpgrade(1);
		assertEquals(1, member.getUpgrade());
		assertEquals(20000, member.getMiles());
	}
	
	@Test
	public void shouldPurchaseThreeUpgradesWithMiles() {
		member.purchaseUpgrade(3);
		assertEquals(3, member.getUpgrade());
		assertEquals(0, member.getMiles());
	}
	
	@Test(expected = InsufficientFundException.class )
	public void shouldNotPurchaseUpgradeWithInsufficientMiles() {
		member.purchaseUpgrade(4);
	}
	
	@Test
	public void shouldPurchaseUpgradeWithCC() {
		// Given
		CASSpy cas = new CASSpy();
		cas.setValidCC("cc1");
		member.setCAS(cas);
		
		// When
		member.purchaseUpgradeWithCC(1,"cc1");
		
		// Then
		assertEquals(1, member.getUpgrade());
		assertEquals(100, cas.getAmt());
	}

	@Test (expected = InvalidCCException.class)
	public void shouldNotPurchaseUpgradeWithInvalidCC() {
		CASSpy cas = new CASSpy();
		member.setCAS(cas);
		member.purchaseUpgradeWithCC(1,"invalidCC");
	}
}
