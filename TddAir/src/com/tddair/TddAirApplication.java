package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class TddAirApplication {

	
	private FlightDao flights = new FlightDao();
	private Map<String, Member> memberMap = new HashMap<>();
	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public Member registerAsMember(String username, String email) {
		if( lookUpMember(username) != null )
		{
			throw new RuntimeException("Username is already registered");
		}
		Member member = new Member(username, "donmc@gmail.com");
		memberMap.put(username, member);
		return member;
	}

	public Member lookUpMember(String username) {
		return memberMap.get(username);
	}

	public void completeFlight(Member member, String flightNumber) {
		member.completeFlight(flights.getFlightBy(flightNumber));
	}
}
