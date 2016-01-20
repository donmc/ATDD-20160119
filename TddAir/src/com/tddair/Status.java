package com.tddair;

public enum Status {

	RED, GREEN, BLUE;

	public static Status getStatus(int miles)
	{
		Status currentStatus = RED;
		
		if(miles > 25000)
		{
			currentStatus = GREEN;
		}
		
		return currentStatus;
	}
}
