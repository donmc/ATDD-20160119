package com.tddair.exceptions;

public class InsufficientBalanceException extends Exception {
	private static final long serialVersionUID = 6729142748200520812L;

	public InsufficientBalanceException() {
	}

	public InsufficientBalanceException(String message) {
		super(message);
	}

	public InsufficientBalanceException(Throwable cause) {
		super(cause);
	}

	public InsufficientBalanceException(String message, Throwable cause) {
		super(message, cause);
	}

	public InsufficientBalanceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
