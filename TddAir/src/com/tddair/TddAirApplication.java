package com.tddair;

import java.util.ArrayList;
import java.util.List;

public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	private List<Member> members = new ArrayList<Member>();
	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public void registerAsMember(String username, String email) throws DuplicateMemberException {
		if (lookUpMember(username) != null) {
			throw new DuplicateMemberException("Duplicate username");
		}
		members.add(new Member(username, email));
	}

	public Member lookUpMember(String userName) {
		for(Member member : members) {
			if(member.getUserName().equals(userName)) {
				return member;
			}
		}
		return null;
	}
}
