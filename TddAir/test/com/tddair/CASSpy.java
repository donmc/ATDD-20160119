package com.tddair;

public class CASSpy extends CAS {
	private int amt;

	public void approve(String ccNum, int amt){
		super.approve(ccNum, amt);
		this.amt = amt;
	}
	
	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public void setValidCC(String cc) {
		this.validCC.put(cc, cc);
	}
}
