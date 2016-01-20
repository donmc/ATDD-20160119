package com.tddair;

public class DuplicateUserException extends RuntimeException {

	private static final long serialVersionUID = -5085524333336230994L;

	public String getMessage() {
		return "Duplicate Username!";
	}

}
