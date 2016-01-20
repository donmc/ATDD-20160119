package com.tddair;

public enum Status {

	RED, GREEN, BLUE, GOLD;

	public static Status getStatus(int miles)
	{
		Status currentStatus = RED;
		
		if (miles > 75000) {
			currentStatus = GOLD;
		} else if (miles > 50000) {
			currentStatus = BLUE;
		} else if (miles > 25000) {
			currentStatus = GREEN;
		}
		
		return currentStatus;
	}
}
