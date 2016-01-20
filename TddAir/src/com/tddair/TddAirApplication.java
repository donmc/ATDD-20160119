package com.tddair;


public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	private MemberDao members = new MemberDao();
	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public void registerAsMember(String username, String email) {
		members.registerMember(username, email);
	}

	public Member lookUpMember(String username) {
		return members.getMember(username);
	}

	public void completeFlight(Member member, String flightNumber) {
		member.completeFlight(flights.getFlightBy(flightNumber));
	}
}
