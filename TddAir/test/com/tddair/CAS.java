package com.tddair;

import java.math.BigDecimal;

public interface CAS {

	public boolean processTransaction(String creditCardNumber, BigDecimal amount);
	
	public int getTransactionCount();
	
	public BigDecimal getTransactionCost();
}
