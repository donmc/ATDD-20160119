package com.tddair;

public class Member {
	private String username;
	private String email;
	private Status status = Status.Red;
	private int ytdMiles = 0;
	private int miles = 10000;

	public Member(String username, String email) {
		this.username = username;
		this.email = email;
	}
	
	public Member(String username, String email, Status status, int ytdMiles, int miles) {
		super();
		this.username = username;
		this.email = email;
		this.status = status;
		this.ytdMiles = ytdMiles;
		this.miles = miles;
	}

	public String getUserName() {
		return username;
	}

	public Status getStatus() {
		return status;
	}

	public int getYtdMiles() {
		return ytdMiles;
	}

	public void addFlightMiles(int flightMiles) {
		ytdMiles += flightMiles;
		miles += flightMiles;
	}

	public int getMiles() {
		return miles;
	}

	public void completeFlight(Flight flight) {
		addFlightMiles(flight.getMileage());
		
		if(25000 <= ytdMiles && ytdMiles < 50000)
		{
			status = Status.Green;
		} 
		else if(50000 <= ytdMiles && ytdMiles < 75000)
		{
			status = Status.Blue;
		}
		else if(75000 <= ytdMiles )
		{
			status = Status.Golden;
		}
	}
}
