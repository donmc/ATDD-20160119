package com.tddair;

import com.tddair.exception.InsufficientFundException;

public class Member {
	private String username;
	private String email;
	private Status status = Status.Red;
	private int ytdMiles = 0;
	private int miles = 10000;
	private int upgrade = 0;
	private CAS cas;

	public Member(String username, String email) {
		this.username = username;
		this.email = email;
	}
	
	public Member(String username, String email, Status status, int ytdMiles, int miles) {
		super();
		this.username = username;
		this.email = email;
		this.status = status;
		this.ytdMiles = ytdMiles;
		this.miles = miles;
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

	public void addFlightMiles(int flightMiles) {
		ytdMiles += flightMiles;
		miles += flightMiles;
	}

	public int getMiles() {
		return miles;
	}

	public void completeFlight(Flight flight) {
		addFlightMiles(flight.getMileage());
		
		status = status.calculateStatus(ytdMiles);
	}

	public void purchaseUpgrade(int i) {
		if(this.miles >= (this.status.getUpgradeCost() * i))
		{
			this.upgrade += i;
			this.miles -= (this.status.getUpgradeCost() * i);
		}
		else
		{
			throw new InsufficientFundException();
		}
	}

	public Object getUpgrade() {
		return upgrade;
	}

	public void purchaseUpgradeWithCC(int numOfUpgrades, String ccNum) {
		this.upgrade += numOfUpgrades;
		cas.approve(ccNum, status.getUpgradeDollarCost() * numOfUpgrades);
	}
	
	public void setCAS(CAS cas){
		this.cas = cas;
	}
}
