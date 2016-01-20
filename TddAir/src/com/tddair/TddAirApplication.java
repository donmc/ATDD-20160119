package com.tddair;


public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	private MemberDAO memberDAO = new MemberDAO();
	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public void registerAsMember(String userName, String email) {
		memberDAO.add(new Member(userName, email));
	}

	public Member lookUpMember(String userName) {
		return memberDAO.getMemberByUserName(userName);
	}
}
