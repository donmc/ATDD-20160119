package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MemberTest {
	Member member = new Member("raquel", "boss@raquelville.com");
	
	@Test
	public void testGetInfo() {
		Flight flight = new Flight("DFW", "ORD", 920, "AA", 453);
		assertEquals("AA453 | DFW -> ORD | 920 miles", flight.getInfo());
	};
	
	
}
