package com.tddair;

import java.math.BigDecimal;

public enum Status {

	RED(0, 10000, BigDecimal.valueOf(100)), GREEN(25000, 9000, BigDecimal.valueOf(90)), BLUE(50000, 8000,
			BigDecimal.valueOf(75)), GOLD(75000, 7000, BigDecimal.valueOf(60));

	private int threshold;
	private int upgradeCostInMiles;
	private BigDecimal upgradeCostInDollars;

	private Status(int threshold, int upgradeCostInMiles, BigDecimal upgradeCostInDollars) {
		this.threshold = threshold;
		this.upgradeCostInMiles = upgradeCostInMiles;
		this.upgradeCostInDollars = upgradeCostInDollars;
	}

	public static Status getStatus(int miles) {
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

	public int getUpgradeCostInMiles() {
		return upgradeCostInMiles;
	}

	public BigDecimal getUpgradeCostInDollars() {
		return upgradeCostInDollars;
	}
}
