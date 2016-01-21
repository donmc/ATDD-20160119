package com.tddair;

public class Member {
	
	private String username;
	private String email;
	private Status status;
	private int milesBalance;
	private int ytdMiles;
	private int upgrades;

	public Member(String username, String email) {
		this.username = username;
		this.email = email;
		this.status = Status.Red;
		this.milesBalance = 10000;
		this.ytdMiles = 0;
		this.upgrades = 0;
	}
	
	public void completeFlight(Flight flight) {
		updateBalances(flight);
		
		if(!(ytdMiles < status.statusThreshold))
		{
			this.status = status.getStatus(this.ytdMiles);	
		}
	}
	
	//From Miles
	//Miles -= amount * number Of Upgrades
	public void purchaseUpgrade(int numberOfUpgrades)
	{
		
	}
	
	public void purchaseUpgrade(int numberOfUpgrades, String ccNumber)
	{
		
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
	
	private void updateBalances(Flight flight)
	{
		ytdMiles += flight.getMileage();
		milesBalance += flight.getMileage();
	}

	
}
