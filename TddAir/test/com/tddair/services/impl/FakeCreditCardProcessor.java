package com.tddair.services.impl;

import com.tddair.services.CreditCardProcessor;
import com.tddair.services.exceptions.CardDeclinedException;

public class FakeCreditCardProcessor implements CreditCardProcessor {
	
	private double chargeLimit = Double.MAX_VALUE;
	
	@Override
	public boolean charge(String creditCardNumber, double amount) throws CardDeclinedException {
		if(amount > chargeLimit) {
			throw new CardDeclinedException(String.format("Unable to charge $%0.2f", amount));
		}
		return true;
	}

	public void setChargeLimit(double chargeLimit) {
		this.chargeLimit = chargeLimit;
	}
}
