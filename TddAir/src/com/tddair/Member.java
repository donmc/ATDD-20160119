package com.tddair;

public class Member {

	private String userName;
	private Category status;
	private Integer milesBalance;
	private Integer ytdMiles;

	public Member(String userName) {
		super();
		this.userName = userName;
		milesBalance = new Integer(0);
		ytdMiles = new Integer(0);
	}

	public String getUserName() {
		return userName;
	}

	public Category getStatus() {
		return Category.Red;
	}
	
	public void setStatus(Category status) {
		this.status = status;
	}


	public Integer getYtdMiles() {
		return this.ytdMiles;
	}

	public void setYtdMiles(Integer ytdMiles) {
		this.ytdMiles = ytdMiles;
	}

	public Integer getMilesBalance() {
		return this.milesBalance;
	}

	public void setMilesBalance(Integer milesBalance) {
		this.milesBalance = milesBalance;
	}

	public void completeFlight(Flight completedFlight) {
		addMiles(completedFlight.getMileage());
	}

	private void addMiles(int miles)
	{
		this.milesBalance = this.milesBalance + miles;
		this.ytdMiles = this.ytdMiles + miles;
	}

	


}
