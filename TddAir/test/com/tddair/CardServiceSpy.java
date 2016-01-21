package com.tddair;

public class CardServiceSpy extends CardService {
	
	private double purchaseAmount;
	
	public CardServiceSpy(double balance) {
		this.setBalance(balance);
	}
	
	public boolean approve(String cardNo, double purchaseAmount) throws Exception   
	{
		this.purchaseAmount = purchaseAmount;
		return super.approve(cardNo, purchaseAmount);
	}

	public double getPurchaseAmount() {
		return purchaseAmount;
	}
}
