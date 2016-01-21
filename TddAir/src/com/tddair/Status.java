package com.tddair;

public enum Status {

	Red(0),
	Green(25000),
	Blue(50000),
	Golden(75000);
	
	int statusThreshold = 0;
	
	private Status(int threshold)
	{
		this.statusThreshold = threshold;
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
}
