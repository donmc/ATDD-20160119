package com.tddair.exception;

public class InsufficientFundException extends RuntimeException {
	public InsufficientFundException(){
		super("Insufficient funds!");
	}
}
