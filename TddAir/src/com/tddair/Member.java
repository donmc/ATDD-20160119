package com.tddair;

public class Member {
	
	String username;
	String email;
	Status status;
	int balance;
	int ytdMiles;
	
	public Member(String username, String email) {
		this.username = username;
		this.email = email;
		this.status = Status.RED;
		balance = MemberConstants.PROMOTIONAL_BONUS_MILES;
		ytdMiles = 0;
	}
	
	public String getUserName() 
	{
		return username;
	}

	public Status getStatus() {
		return status;
	}

	public int getBalance() {
		return balance;
	}

	public int getYtdMiles() {
		return ytdMiles;
	}

	public String getEmail() {
		return email;
	}

	public void completeFlight(Flight flight) {
		ytdMiles += flight.getMileage();
	}

}
