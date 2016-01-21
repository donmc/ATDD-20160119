package com.tddair.services.impl;

import com.tddair.services.CreditCardProcessor;

public class AmericanExpressCreditCardProcessor implements CreditCardProcessor {
	@Override
	public boolean charge(String creditCardNumber, double amount) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

}
