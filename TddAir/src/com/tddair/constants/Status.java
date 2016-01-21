package com.tddair.constants;

public enum Status {
	/** Red, [0, 25000) miles */
	RED("Red", 1, 0, 25000, 10000, 100.00),
	/** Green, [25000, 50000) miles */
	GREEN("Green", 2, 25000, 50000, 9000, 90.00),
	/** Blue, [50000, 75000) miles */
	BLUE("Blue", 3, 50000, 75000, 8000, 75.00),
	/** Golden, [75000, +INF) miles */
	GOLDEN("Golden", 4, 75000, Integer.MAX_VALUE, 7000, 60.00);
	
	private final String displayName;
	private final int level;
	private final int minLevelMiles;
	private final int maxLevelMiles;
	private final int upgradeCostWithMiles;
	private final double upgradeCostWithCC;
	
	private Status(String displayName, int level, int minLevelMiles, int maxLevelMiles,
					int upgradeCostWithMiles, double upgradeCostWithCC) {
		this.displayName = displayName;
		this.level = level;
		this.minLevelMiles = minLevelMiles;
		this.maxLevelMiles = maxLevelMiles;
		this.upgradeCostWithMiles = upgradeCostWithMiles;
		this.upgradeCostWithCC = upgradeCostWithCC;
	}

	public String getDisplayName() {
		return displayName;
	}

	public int getLevel() {
		return level;
	}

	/**
	 * @return The low end of the mileage range for this status, inclusive
	 */
	public int getMinLevelMiles() {
		return minLevelMiles;
	}
	
	/**
	 * @return The high end of the mileage range for this status, exclusive
	 */
	public int getMaxLevelMiles() {
		return maxLevelMiles;
	}
	
	public int getUpgradeCostWithMiles() {
		return upgradeCostWithMiles;
	}

	public double getUpgradeCostWithCC() {
		return upgradeCostWithCC;
	}

	public boolean isLowerThan(final Status other) {
		final boolean lower = (this.getLevel() < other.getLevel());
		return lower;
	}
	
	/**
	 * Converts a string such as "Red" into the corresponding Status instance.
	 * 
	 * @param displayName
	 * @return
	 * @throws IllegalArgumentException if there is no matching enum value
	 */
	public static Status fromDisplayName(final String displayName) {
		for(final Status s : Status.values()) {
			if(s.getDisplayName().equals(displayName)) {
				return s;
			}
		}
		
		throw new IllegalArgumentException("No Status found named '" + displayName + "'");
	}

	public static Status upgradeStatus(Status currentStatus, int currentYTDBalance) {
		Status upgradeStatus;
		
		if (currentYTDBalance >= Status.GOLDEN.getMinLevelMiles()) {
			upgradeStatus = Status.GOLDEN;
		} else if (currentYTDBalance >= Status.BLUE.getMinLevelMiles()) {
			upgradeStatus = Status.BLUE;
		} else if (currentYTDBalance >= Status.GREEN.getMinLevelMiles()) {
			upgradeStatus = Status.GREEN;
		} else {
			upgradeStatus = currentStatus;
		}
		
		return upgradeStatus;
	}
}
