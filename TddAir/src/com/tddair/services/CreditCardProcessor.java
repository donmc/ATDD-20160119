package com.tddair.services;

import com.tddair.services.exceptions.CardDeclinedException;

public interface CreditCardProcessor {
	/**
	 * Process a credit card charge
	 * 
	 * @param creditCardNumber
	 * @param amount
	 *            The charge amount in USD
	 * @return <code>true</code> if the charge went through, <code>false</code>
	 *         otherwise
	 * @throws CardDeclinedException 
	 */
	public boolean charge(final String creditCardNumber, final double amount) throws CardDeclinedException;
}
