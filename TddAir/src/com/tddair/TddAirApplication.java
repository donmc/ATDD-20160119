package com.tddair;

import java.util.ArrayList;
import java.util.List;

public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	private List<Member> memberList = new ArrayList<Member>();
	
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
		memberList.add(member);
		return member;
	}

	public Member lookUpMember(String username) {
		for(Member member: memberList){
			if(username.equals(member.getUserName())){
				return member;
			}	
		}
		return null;
	}
}
