package com.tddair;

public class Member {
	private int PROMOTIONAL_BONUS_MILES = 10000;
	
	String username;
	String email;
	Status status;
	int balance;
	
	public Member(String username, String email) {
		this.username = username;
		this.email = email;
		this.status = Status.RED;
		balance = PROMOTIONAL_BONUS_MILES;
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
		return -1;
	}

}
