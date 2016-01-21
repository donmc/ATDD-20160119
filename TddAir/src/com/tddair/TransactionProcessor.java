package com.tddair;

public class TransactionProcessor {

	private static CAS cas = null;
	
	public static CAS getInstance() {
		// TODO : return CAS from property
		if (cas == null) {
			cas = new CASSpy();
		}
		
		
		return cas;
	}
	
}
