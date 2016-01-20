package com.tddair;


public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	private MemberDAO members = new MemberDAO();
	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public Member lookUpMember(String username) {
		return members.getMember(username);
	}

	public void registerAsMember(String username, String email) {
		Member newMember = new Member(username);
		members.saveMember(newMember);
	}
}
