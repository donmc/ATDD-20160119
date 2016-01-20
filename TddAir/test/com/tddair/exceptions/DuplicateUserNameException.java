package com.tddair.exceptions;

public class DuplicateUserNameException extends Exception {
	private static final long serialVersionUID = -98741492310892675L;

	public DuplicateUserNameException() {
	}

	public DuplicateUserNameException(String message) {
		super(message);
	}

	public DuplicateUserNameException(Throwable cause) {
		super(cause);
	}

	public DuplicateUserNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateUserNameException(
			String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
