package com.tddair;

import java.util.List;

import com.tddair.exceptions.DuplicateUserNameException;

public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	private MemberDAO memberDAO = new MemberDAO();
	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}
	
	/**
	 * Registers a new member with the given user name and email address, and
	 * other default settings.
	 * 
	 * @param userName
	 * @param email
	 * @throws DuplicateUserNameException 
	 */
	public void registerAsMember(String userName, String email) throws DuplicateUserNameException {
		memberDAO.add(new Member(userName, email));
	}
	
	/**
	 * Looks up a member by user name.
	 * 
	 * @param userName
	 * @return The Member, or <code>null</code> if no member was found with the
	 *         given user name
	 */
	public Member lookUpMember(String userName) {
		return memberDAO.getMemberByUserName(userName);
	}

	public List<Member> getRegisteredMembers() {
		return this.memberDAO.getAllMembers();
	}
	
	public FlightDao getFlightDao() {
		return flights;
	}

	public MemberDAO getMemberDAO() {
		return this.memberDAO;
	}

	public void completeFlight(Member member, String flightNumber) {
		//Get the FlightDAO object for the flightNumber
		Flight currentFlight = flights.getFlightBy(flightNumber);
		
		memberDAO.incrementBalanceForCompleteFlight(member, currentFlight.getMileage());
		memberDAO.checkUpgradeStatus(member);
	}
}
