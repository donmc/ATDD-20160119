package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class WhenRegisteringFlyers {

	private Flyer member;

	TddAirApplication app;

	@Before
	public void setup() {
		String username = "username";
		String email = "user@name.com";
		app = new TddAirApplication();
		app.registerNewFlyer(new Flyer(username, email));
		member = app.getFlyer(username);
	}

	@Test
	public void shouldSaveFlyerAsMember() {
		// validate
		assertNotNull(member);
		assertEquals(member.getEmail(), "user@name.com");
		assertEquals(member.getUsername(), "username");
	}

	@Test
	public void shouldSaveRedStatus() {
		assertNotNull(member);
		assertEquals(member.getStatus(), "Red");
	}

	@Test
	public void shouldHaveStatusDependentOnMiles() {
		assertNotNull(member);
		member.setYtdMiles(25000);
		assertEquals(member.getStatus(), "Green");
	}

	@Test
	public void shouldInitializeWithZeroYtdMiles() {
		assertNotNull(member);
		assertEquals(0, member.getYtdMiles());
	}

	@Test
	public void ytdMilesShouldMatchUpdatedValue() {
		member.setYtdMiles(23508234);
		assertNotNull(member);
		assertEquals(23508234, member.getYtdMiles());
	}

	@Test
	public void shouldReturnGoldStatus() {
		member.setYtdMiles(123456);
		assertEquals(Flyer.GOLD_STATUS, member.getStatus());
	}

	@Test
	public void shouldReturnBlueStatus() {
		member.setYtdMiles(55555);
		assertEquals(Flyer.BLUE_STATUS, member.getStatus());
	}

	@Test
	public void shouldIgnoreNegativeMilesValue() {
		member.setYtdMiles(-123456);
		assertEquals(Flyer.RED_STATUS, member.getStatus());
	}

	@Test
	public void shouldHaveDefaultMilesBalanceAsNewMember() {
		assertEquals(Flyer.DEFAULT_BALANCE_INITIAL_VALUE, member.getBalance());
	}

	@Test
	public void shouldErrorWithDupeUserName() {
		try {
			app.registerNewFlyer(new Flyer("username", "other@name.com"));
			fail("Should throw DuplicateUserException");
		} catch (DuplicateUserException e) {
			assertEquals("Duplicate Username!", e.getMessage());
		}
	}
}
