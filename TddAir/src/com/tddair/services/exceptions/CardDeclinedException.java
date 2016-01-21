package com.tddair.services.exceptions;

public class CardDeclinedException extends Exception {
	private static final long serialVersionUID = -3421647228330740438L;

	public CardDeclinedException() {
		super();
	}

	public CardDeclinedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CardDeclinedException(String message, Throwable cause) {
		super(message, cause);
	}

	public CardDeclinedException(String message) {
		super(message);
	}

	public CardDeclinedException(Throwable cause) {
		super(cause);
	}
	
}
