package com.tddair;

import java.util.HashMap;

public class CreditAuthorizationThingy {
	private HashMap<String, Double> availableCredit = new HashMap<String, Double>();
	
	public void addCard(String cc, double creditLimit) {
		this.availableCredit.put(cc, creditLimit);
	}
	
	public boolean authorize(String cc, double amount) {
		if (cc.length() != 16) {
			throw new IllegalArgumentException();
		}
		if (availableCredit.containsKey(cc)) {
			double credit = availableCredit.get(cc);
			if (credit > amount) {
				availableCredit.replace(cc, credit, credit - amount);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
