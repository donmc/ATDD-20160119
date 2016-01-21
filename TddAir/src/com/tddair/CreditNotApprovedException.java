package com.tddair;

public class CreditNotApprovedException extends RuntimeException {
	
	public CreditNotApprovedException(String message) {
		super(message);
	}

}
