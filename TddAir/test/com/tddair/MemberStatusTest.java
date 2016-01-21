package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class MemberStatusTest {

	@Test
	public void getStatus_With10000Miles() {
		MemberStatus status = MemberStatus.getStatus(10000);
		assertEquals(MemberStatus.RED, status);
	}
	
	@Test
	public void getStatus_WithZeroMiles() {
		MemberStatus status = MemberStatus.getStatus(0);
		assertEquals(MemberStatus.RED, status);
	}
	
	@Test
	public void getStatus_WithNegativeMiles() {
		MemberStatus status = MemberStatus.getStatus(-10000);
		assertEquals(MemberStatus.RED, status);
	}

	@Test
	public void getStatus_With30000Miles() {
		MemberStatus status = MemberStatus.getStatus(30000);
		assertEquals(MemberStatus.GREEN, status);
	}
	
	@Test
	public void getStatus_With70000Miles() {
		MemberStatus status = MemberStatus.getStatus(70000);
		assertEquals(MemberStatus.BLUE, status);
	}
	
	@Test
	public void getStatus_With80000Miles() {
		MemberStatus status = MemberStatus.getStatus(80000);
		assertEquals(MemberStatus.GOLDEN, status);
	}
}
