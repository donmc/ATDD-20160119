package com.tddair;

public enum Status {
	Red(0, 10000, 100), Green(25000, 9000, 90), Blue(50000, 8000, 75), Golden(75000, 7000, 60);

	private int threshold;
	private int upgradeCost;
	private int upgradeDollarCost;

	private Status(int threshold, int upgradeCost, int upgradeDollarCost) {
		this.threshold = threshold;
		this.upgradeCost = upgradeCost;
		this.upgradeDollarCost = upgradeDollarCost;
	}

	public Status calculateStatus(int ytdMiles) {
		Status status = Status.Red;

		if (ytdMiles >= Status.Golden.getThreshold()) {
			status = Status.Golden;
		} else if (ytdMiles >= Status.Blue.getThreshold()) {
			status = Status.Blue;
		} else if (ytdMiles >= Status.Green.getThreshold()) {
			status = Status.Green;
		}

		return status;
	}

	public int getThreshold() {
		return threshold;
	}
	

	public int getUpgradeCost() {
		return upgradeCost;
	}
	
	public int getUpgradeDollarCost() {
		return upgradeDollarCost;
	}
}
