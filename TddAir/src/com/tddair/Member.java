package com.tddair;

public class Member {
	
	private String username;
	private String email;
	private Status status;
	//private int status;
	private int milesBalance;
	private int ytdMiles;

	public Member(String username, String email) {
		this.username = username;
		this.email = email;
		this.status = Status.Red;
		this.milesBalance = 10000;
		this.ytdMiles = 0;
		
		System.out.println("Constructor status = " + this.status);
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
		//return Constants.STATUS_MAP.get(status);
		return status;
	}
	
	public void setStatus(Status status) {
		//this.status = status;
		this.status = status;
		
		System.out.println("Status is = " + this.status);
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
