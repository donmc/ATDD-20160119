package com.tddair;

public interface CreditSystem {
	
	public boolean approve(String ccNumber, int amount);

	public int getAmountProcessed();

	public int getAvailableBalance();

}
