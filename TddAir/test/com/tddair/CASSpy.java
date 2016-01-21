package com.tddair;

public class CASSpy implements CAS {

	private int totalAmount;
	private int countApprovedCalled;
	
	@Override
	public void approve(String creditCardToken, int amount) {
		setTotalAmount(getTotalAmount() + amount);
		setCountApprovedCalled(getCountApprovedCalled() + 1);
	}

	public int getCountApprovedCalled() {
		return countApprovedCalled;
	}

	public void setCountApprovedCalled(int countApprovedCalled) {
		this.countApprovedCalled = countApprovedCalled;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

}
