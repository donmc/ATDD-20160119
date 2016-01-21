package com.tddair;


public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public void registerAsMember(String userName, String email) throws Exception
	{
		// validate input 
		if(userName == null || userName.isEmpty())
		{
			throw new Exception("User Name can not be null or Empty!!");
		}
		
		if(! isValidEmailAddress(email))
		{
			throw new Exception("Invalid Email format !!");
		}
		
		Member member = new Member(userName, email);
		member.setStatus(MemberStatus.RED);
		member.setBalanceMiles(10000);
		member.setYtdMiles(0);
		
		MemberDB.getMemberDB().addMember(member);
	}

	public Member lookupMember(String userName) { 

		return MemberDB.getMemberDB().getMember(userName);  
	}
	
	  public boolean isValidEmailAddress(String email) {
          String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
          java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
          java.util.regex.Matcher m = p.matcher(email);
          return m.matches();
   }

	public void completeFlight(String userName, String fullFlightNumber) {
		Member member = MemberDB.getMemberDB().getMember(userName);
		Flight flight = flights.getFlightBy(fullFlightNumber);
		if (member != null && flight!= null) {
			member.completeFlight(flight.getMileage());
		}
		
	}
}
