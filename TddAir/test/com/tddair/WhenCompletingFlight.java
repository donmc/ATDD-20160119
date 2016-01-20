package com.tddair;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class WhenCompletingFlight {
	private Member member;
	private Flight flight;
	
	@Before
	public void setup()
	{
		member = new Member("Collin","collin@gmail");
	}
	
	@Test
	public void shouldGoFromRedToGreen() throws Throwable {
		// Given
		member = new Member("username", "email", Status.Red, 0, 0);
		flight = new Flight("aaa", "bbb", 25000, "mock", 25000);
		
		// When
		member.completeFlight(flight);
		
		// Then
	    assertEquals(Status.Green, member.getStatus());
	    assertEquals(25000, member.getYtdMiles());
	    assertEquals(25000, member.getMiles());
	}
	
	@Test
	public void shouldGoFromGreenToGreen() throws Throwable {
		// Given
		member = new Member("username", "email", Status.Green, 25000, 25000);
		flight = new Flight("aaa", "bbb", 100, "mock", 100);

		// When
		member.completeFlight(flight);
		
		// Then
	    assertEquals(Status.Green, member.getStatus());
	    assertEquals(25100, member.getYtdMiles());
	    assertEquals(25100, member.getMiles());
	}
	@Test
	public void shouldGoFromGreenToBlue() throws Throwable {
		// Given
		member = new Member("username", "email", Status.Green, 25000, 25000);
		flight = new Flight("aaa", "bbb", 25000, "mock", 25000);

		// When
		member.completeFlight(flight);
		
		// Then
	    assertEquals(Status.Blue, member.getStatus());
	    assertEquals(50000, member.getYtdMiles());
	    assertEquals(50000, member.getMiles());
	}
	
	@Test
	public void shouldGoFromBlueToGolden() throws Throwable {
		// Given
		member = new Member("username", "email", Status.Blue, 50000, 50000);
		flight = new Flight("aaa", "bbb", 25000, "mock", 25000);

		// When
		member.completeFlight(flight);
		
		// Then
	    assertEquals(Status.Golden, member.getStatus());
	    assertEquals(75000, member.getYtdMiles());
	    assertEquals(75000, member.getMiles());
	}
	
	@Test
	public void shoudlGoFromRedToGolden() throws Throwable {
		// Given
		member = new Member("username", "email", Status.Red, 0, 0);
		flight = new Flight("aaa", "bbb", 75000, "mock", 75000);

		// When
		member.completeFlight(flight);
		
		// Then
	    assertEquals(Status.Golden, member.getStatus());
	    assertEquals(75000, member.getYtdMiles());
	    assertEquals(75000, member.getMiles());
	}
}
