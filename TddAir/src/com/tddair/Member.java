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

	public String getUserName() {
		return username;
	}

	public Status getStatus() {
		return status;
	}

	public int getYtdMiles() {
		return ytdMiles;
	}

	public int getMiles() {
		return miles;
	}
}
