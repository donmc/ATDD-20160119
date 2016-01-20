package com.tddair;

public enum MemberStatus {
	
	RED(0, 25000, 10000, 100),
	GREEN(25001, 50000, 9000, 90),
	BLUE(50001, 75000, 8000, 75),
	GOLDEN(75001, 999999999, 7000, 60);
	
	private long minMiles;
	private long maxMiles;
	private long upgradeInMile;
	private long upgradeInDollars;
	
	MemberStatus(long minMiles, long maxMiles, long upgradeInMiles, long upgradeInDollars) {
		
		this.minMiles = minMiles;
		this.maxMiles = maxMiles;
		this.upgradeInMile = upgradeInMiles;
		this.upgradeInDollars = upgradeInDollars;
	}
}
