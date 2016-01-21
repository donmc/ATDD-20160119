package com.tddair;

import java.math.BigDecimal;

public class Member {
	
	String username;
	String email;
	Status status;
	int balance;
	int ytdMiles;
	int upgradeCount;
	
	public Member(String username, String email) {
		this.username = username;
		this.email = email;
		this.status = Status.RED;
		balance = MemberConstants.PROMOTIONAL_BONUS_MILES;
		ytdMiles = 0;
		upgradeCount = 0;
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
		return ytdMiles;
	}

	public String getEmail() {
		return email;
	}
	
	public void setYtdMiles(int miles) {
		this.ytdMiles = miles;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public void completeFlight(Flight flight) {
		int mileage = flight.getMileage();
		
		updateBalance(mileage);
		updateYtdMiles(mileage);
		updateStatus();
	}

	private void updateBalance(int mileage) {
		balance += mileage;
	}

	private void updateYtdMiles(int mileage) {
		ytdMiles += mileage;
	}

	public void updateStatus() {
		status = Status.getStatus(ytdMiles);
	}

	public boolean purchaseUpgradeWithMiles(int numberOfUpgrades) {
		boolean purchaseStatus = false;
		
		int upgradeCost = (status.getUpgradeCostInMiles() * numberOfUpgrades);
		
		if(upgradeCost <= balance)
		{
			purchaseStatus = true;
			balance -= upgradeCost;
			this.upgradeCount += numberOfUpgrades;
		}
		
		return purchaseStatus;
	}

	public int getUpgradeCount() {
		return upgradeCount;
	}

	public boolean purchaseUpgradeWithCC(int numberUpgradesToPurchase, String ccNumber) {
		BigDecimal upgradeCostInDollars = status.getUpgradeCostInDollars().multiply(BigDecimal.valueOf(numberUpgradesToPurchase));
		
		boolean isPurchaseSuccessful = TransactionProcessor.getInstance().processTransaction(ccNumber, upgradeCostInDollars);
		if (isPurchaseSuccessful) {
			upgradeCount += numberUpgradesToPurchase;
		}
		
		return isPurchaseSuccessful;
	}

}
