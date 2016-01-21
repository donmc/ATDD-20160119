package com.tddair;

public class Member {
	
	private String username;
	private String email;
	private Status status;
	private int milesBalance;
	private int ytdMiles;
	private int upgrades;
	private CreditSystem creditSystem;

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

	public void purchaseUpgrade(int numberOfUpgrades)
	{
		int costOfUpgrades = numberOfUpgrades * status.getMilesCost();
		
		if(costOfUpgrades > milesBalance)
		{
			throw new InsuffiecentMilesException("Your Balance is too low.");
		}
		
		milesBalance -= costOfUpgrades;
		incrementUpgrades(numberOfUpgrades);
		
	}
	
	public void purchaseUpgrade(int numberOfUpgrades, String ccNumber)
	{
		int costOfUpgrades = numberOfUpgrades * status.getDollarCost();
		boolean approved = creditSystem.approve(ccNumber, costOfUpgrades);
		if(!approved) {
			throw new CreditNotApprovedException("Insufficient credit");
		}
		incrementUpgrades(numberOfUpgrades);
	}

	private void incrementUpgrades(int numberOfUpgrades) {
		upgrades += numberOfUpgrades;
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
	
	public void setMilesBalance(int milesBalance) {
		this.milesBalance = milesBalance;
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

	public int getUpgrades() {
		return upgrades;
	}

	public void setCreditSystem(CreditSystem creditSystem) {
		this.creditSystem = creditSystem;
	}

	
}
