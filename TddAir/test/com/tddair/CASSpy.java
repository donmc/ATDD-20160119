package com.tddair;

import java.math.BigDecimal;

public class CASSpy implements CAS {
	
	private int transactionCount = 0;
	
	private BigDecimal transactionAmount = BigDecimal.ZERO;
	
	@Override
	public boolean processTransaction(String creditCardNumber, BigDecimal amount) {
		transactionCount++;
		transactionAmount = amount;
		
		return true;
	}

	@Override
	public int getTransactionCount() {
		return transactionCount;
	}

	@Override
	public BigDecimal getTransactionCost() {
		return transactionAmount;
	}

}
