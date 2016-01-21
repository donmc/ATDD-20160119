package com.tddair.constants;

public enum Status {
	/** Red, [0, 25000) miles */
	RED("Red", 1, 0, 25000),
	/** Green, [25000, 50000) miles */
	GREEN("Green", 2, 25000, 50000),
	/** Blue, [50000, 75000) miles */
	BLUE("Blue", 3, 50000, 75000),
	/** Golden, [75000, +INF) miles */
	GOLDEN("Golden", 4, 75000, Integer.MAX_VALUE);
	
	private final String displayName;
	private final int level;
	private final int minLevelMiles;
	private final int maxLevelMiles;
	
	private Status(String displayName, int level, int minLevelMiles, int maxLevelMiles) {
		this.displayName = displayName;
		this.level = level;
		this.minLevelMiles = minLevelMiles;
		this.maxLevelMiles = maxLevelMiles;
	}

	public String getDisplayName() {
		return displayName;
	}

	public int getLevel() {
		return level;
	}

	public int getMinLevelMiles() {
		return minLevelMiles;
	}
	
	public int getMaxLevelMiles() {
		return maxLevelMiles;
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
