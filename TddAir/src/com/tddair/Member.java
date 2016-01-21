package com.tddair;

public class Member {
	
	private String username;
	private String email;
	private Status status;
	private int milesBalance;
	private int ytdMiles;

	public Member(String username, String email) {
		this.username = username;
		this.email = email;
		this.status = Status.Red;
		this.milesBalance = 10000;
		this.ytdMiles = 0;
	}
	
	public void completeFlight(Flight flight) {
		this.ytdMiles += flight.getMileage();
		
		if(ytdMiles >= 75000) {
			status = Status.Golden;
		} else if(ytdMiles >= 50000  && this.status.ordinal() < Status.Blue.ordinal()) {
			status = Status.Blue;
		} else if(ytdMiles >= 25000 && this.status.ordinal() < Status.Green.ordinal()) {
			status = Status.Green;
		}
	}

	public String getUserName() {
		return username;
	}

	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public int getMilesBalance() {
		return milesBalance;
	}

	public int getYtdMiles() {
		return ytdMiles;
	}

	public void setYtdMiles(int ytdMiles) {
		this.ytdMiles = ytdMiles;
	}

	
}
