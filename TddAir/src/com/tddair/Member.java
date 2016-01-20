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
	
	public int getMilesBalance() {
		return milesBalance;
	}
	
	public int getYtdMiles() {
		return ytdMiles;
	}
}
