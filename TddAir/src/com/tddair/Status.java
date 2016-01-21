package com.tddair;

public enum Status {

	Red(0,10000,100),
	Green(25000,9000,90),
	Blue(50000,8000,75),
	Golden(75000,7000,60);
	
	int statusThreshold = 0;
	int milesCost = 0;
	int dollarCost = 0;
	
	private Status(int threshold, int milesCost, int dollarCost)
	{
		this.statusThreshold = threshold;
		this.milesCost = milesCost;
		this.dollarCost = dollarCost;
	}
	
	public Status getStatus(int ytdMiles)
	{
		Status status = Status.Red;
		
		if(ytdMiles >= 75000) {
			status = Status.Golden;
		} else if(ytdMiles >= 50000) {
			status = Status.Blue;
		} else if(ytdMiles >= 25000) {
			status = Status.Green;
		}
		
		return status;
	}

	public int getMilesCost() {
		return milesCost;
	}

	public int getDollarCost() {
		return dollarCost;
	}
}
