package com.tddair;

public enum Status {

	RED(0,10000), GREEN(25000,9000), BLUE(50000,8000), GOLD(75000,7000);
	
	private int threshold;
	private int upgradeCostInMiles;

	private Status(int threshold, int upgradeCostInMiles)
	{
		this.threshold = threshold;
		this.upgradeCostInMiles = upgradeCostInMiles;
	}

	public static Status getStatus(int miles)
	{
		Status currentStatus = RED;
		
		if (miles > GOLD.getThreshold()) {
			currentStatus = GOLD;
		} else if (miles > BLUE.getThreshold()) {
			currentStatus = BLUE;
		} else if (miles > GREEN.getThreshold()) {
			currentStatus = GREEN;
		}
		
		return currentStatus;
	}

	public int getThreshold() {
		return threshold;
	}
	
	public int getUpgradeCostInMiles(){
		return upgradeCostInMiles;
	}
}
