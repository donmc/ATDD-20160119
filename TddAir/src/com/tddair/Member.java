package com.tddair;

public class Member {
	private int PROMOTIONAL_BONUS_MILES = 10000;
	
	String username;
	String email;
	Status status;
	int balance;
	int ytdMiles;
	
	public Member(String username, String email) {
		this.username = username;
		this.email = email;
		this.status = Status.RED;
		balance = PROMOTIONAL_BONUS_MILES;
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
		// TODO Auto-generated method stub
		return ytdMiles;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

}
