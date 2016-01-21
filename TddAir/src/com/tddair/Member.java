package com.tddair;

public class Member {
	private String userName;
	private String email;
	private Status status = Status.RED;
	private int milesBalance = 10000;
	private int ytdMiles = 0;
	private int upgrades = 0;
	
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
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public int getMilesBalance() {
		return milesBalance;
	}
	
	public int getYtdMiles() {
		return ytdMiles;
	}
	
	public void setYtdMiles(int miles) {
		this.ytdMiles = miles;
	}
	
	public int getNumUpgrades() {
		return this.upgrades;
	}
	
	public void completeFlight(Flight flight) {
		this.ytdMiles += flight.getMileage();
		this.milesBalance += flight.getMileage();
		Status tentativeStatus = Status.RED;
		if (this.getYtdMiles() >= 25000) {
			tentativeStatus = Status.GREEN;
		}
		if (this.getYtdMiles() >= 50000) {
			tentativeStatus = Status.BLUE;
		}
		if (this.getYtdMiles() >= 75000) {
			tentativeStatus = Status.GOLD;
		}
		if (this.status.ordinal() < tentativeStatus.ordinal()) {
			status = tentativeStatus;
		}
	}
	
	public int purchaseUpgradesWithMiles(int count) {
		int miles = 0;
		switch (this.status) {
		case RED:
			miles = 10000;
			break;
		case GREEN:
			miles = 9000;
			break;
		case BLUE:
			miles = 8000;
			break;
		case GOLD:
			miles = 7000;
			break;
		}
		
		if (this.milesBalance < miles * count) {
			return 0;
		}
		this.milesBalance -= miles * count;
		return count;
	}
	
	public int purchaseUpgradesWithCreditCard(int count, String cc, CreditAuthorizationThingy thingy) {
		double price = 0;
		switch (this.status) {
		case RED:
			price = 100.00;
			break;
		case GREEN:
			price = 90.00;
			break;
		case BLUE:
			price = 75.00;
			break;
		case GOLD:
			price = 60.00;
			break;
		}
		
		if (thingy.authorize(cc, price * count)) {
			return count;
		}
		else {
			return 0;
		}
	}
}

