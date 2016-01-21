package com.tddair;

public class CreditAuthorizationSpy extends CreditAuthorizationThingy {
	public int authCounterSpy = 0;
	
	public boolean authorize(String cc, double amount) {
		this.authCounterSpy = this.authCounterSpy + 1;
		return super.authorize(cc, amount);
	};
}
