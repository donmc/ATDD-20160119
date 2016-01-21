package com.tddair;

public class CreditSystemSpy implements CreditSystem {
	
	int availableCredit;
	int amountProcessed;

	public CreditSystemSpy(int availableCredit) {
		this.availableCredit = availableCredit;
	}

	@Override
	public boolean approve(String ccNumber, int amount) {
		
		boolean approved = false;
		
		if(isValidCreditCard(ccNumber))
		{
			if(availableCredit >= amount)
			{
				availableCredit -= amount;
				amountProcessed = amount;
				approved =  true;
			}
			else
			{
				throw new InsuffiecentAvailableBalanceException("Insufficient credit");
			}
		}
		else
		{
			throw new InvalidCreditCardNumberException("Invalid Credit Card.");
		}
		
		return approved;
	}

	private boolean isValidCreditCard(String ccNumber) {
		
		return (null != ccNumber && (ccNumber.length() == 15 || ccNumber.length() == 16));
	}

	@Override
	public int getAmountProcessed() {
		return amountProcessed;
	}

	@Override
	public int getAvailableBalance() {
		return availableCredit;
	}

}
