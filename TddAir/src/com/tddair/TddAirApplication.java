package com.tddair;

public class TddAirApplication {

	private FlightDao flights = new FlightDao();
	private MemberDao members = new MemberDao();

	public TddAirApplication() {
	}

	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public void registerNewFlyer(Flyer member) {
		members.addMember(member);
	}

	public Flyer getFlyer(String username) {
		return members.getByUserName(username);
	}
}
