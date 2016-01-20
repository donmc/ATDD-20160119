package com.tddair;

public class Member {
	private String userName;
	private String email;
	private Status status = Status.RED;
	private int milesBalance = 10000;
	private int ytdMiles = 0;
	
	public Member(String userName, String email) {
		this.userName = userName;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getEmail() {
		return email;
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
	
	public void setYtdMiles(int miles) {
		this.ytdMiles = miles;
	}
	
	public void completeFlight(Flight flight) {
		this.ytdMiles += flight.getMileage();
		this.milesBalance += flight.getMileage();
		Status tentativeStatus = Status.RED;
		if (this.getYtdMiles() >= 25000) {
			tentativeStatus = Status.GREEN;
		}
		if (this.getYtdMiles() >= 50000) {
			tentativeStatus = Status.BLUE;
		}
		if (this.getYtdMiles() >= 75000) {
			tentativeStatus = Status.GOLD;
		}
		if (this.status.ordinal() < tentativeStatus.ordinal()) {
			status = tentativeStatus;
		}
	}
}
