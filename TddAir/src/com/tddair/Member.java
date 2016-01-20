package com.tddair;

public class Member {

	String username;
	String email;
	Status status;
	
	public Member(String username, String email) {
		this.username = username;
		this.email = email;
		this.status = Status.RED;
	}
	
	public String getUserName() 
	{
		return username;
	}

	public Status getStatus() {
		return status;
	}

	public int getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

}
