package com.tddair;

public class Member {
	
	private String username;
	private String email;
	private int status;
	private int milesBalance;
	private int ytdMiles;

	public Member(String username, String email) {
		this.username = username;
		this.email = email;
		this.status = Constants.RED_STATUS;
		this.milesBalance = 10000;
		this.ytdMiles = 0;
	}

	public String getUserName() {
		return username;
	}

	public String getStatus() {
		return Constants.STATUS_MAP.get(status);
	}

	public int getMilesBalance() {
		return milesBalance;
	}

	public int getYtdMiles() {
		return ytdMiles;
	}

}
