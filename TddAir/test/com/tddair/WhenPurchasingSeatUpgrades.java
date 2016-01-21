package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class WhenPurchasingSeatUpgrades {

	private Member member;
	
	@Before
	public void setup() {
		member = new Member("user1", "a@b.com");
		member.setBalanceMiles(30000);
		member.setStatus(MemberStatus.RED);
	}

	@Test
	public void shouldPurchaseUpgradeWithMiles() {
		try {
			member.purchaseUpgrade(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(1, member.getUpgradeQTY());
	}
	
	@Test
	public void shouldPurchaseThreeUpgradesWithMiles() {
		try {
			member.purchaseUpgrade(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(3, member.getUpgradeQTY());
	}
	
	@Test
	public void shouldNotPurchaseUpgradeWithInsufficientMiles() {
		try {
			member.purchaseUpgrade(5);
			fail("Should throw an exception");
		} catch (Exception e) {
			assertEquals("Not enough Milage for upgrade !!", e.getMessage());
		}
	}
	
	@Test
	public void shouldPurchaseUpgradeWithCC() {
		member.setCCService(new CardServiceSpy(500.00));
		try {
			member.purchaseUpgradeCC(3, "4147-8123-1234-5678");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(3, member.getUpgradeQTY());
	}
	
	@Test
	public void shouldNotPurchaseUpgradeWithInvalidCC() {
		member.setCCService(new CardServiceSpy(500.00));
		try {
			member.purchaseUpgradeCC(3, null);
		} catch (Exception e) {
			assertEquals("Invalid Card!!", e.getMessage());
		}
		assertEquals(0, member.getUpgradeQTY());
	}
	
	@Test
	public void shouldNotPurchaseUpgradeWithInsufficientBalance() {
		member.setCCService(new CardServiceSpy(500.00));
		try {
			member.purchaseUpgradeCC(10, "4147-8123-1234-5678");
		} catch (Exception e) {
			assertEquals("Insuffient balance !!", e.getMessage());
		}
		assertEquals(0, member.getUpgradeQTY());
	}
	
}
