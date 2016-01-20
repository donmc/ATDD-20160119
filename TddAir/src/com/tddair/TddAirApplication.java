package com.tddair;


public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	private MemberDao members = new MemberDao();
	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public String registerAsMember(String username, String email) {
		
		String registrationStatus = MemberConstants.REGISTRATION_DUPLICATE;
		
		if (!members.contains(username)) {
			
			members.registerMember(username, email);
			
			registrationStatus = MemberConstants.REGISTRATION_SUCCESSFUL;
		}
		
		return registrationStatus;
	}

	public Member lookUp(String username) {
		return members.getMember(username);
	}

	public Flight getFlight(String flightNumber) {
		return flights.getFlightBy(flightNumber);
	}

	public void completeFlight(Member member, Flight flight) {
		member.completeFlight(flight);
	}
}
