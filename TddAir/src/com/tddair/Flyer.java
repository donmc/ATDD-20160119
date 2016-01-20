package com.tddair;

public class Flyer {

	public static final String RED_STATUS = "Red";

	public static final String GREEN_STATUS = "Green";

	public static final String BLUE_STATUS = "Blue";

	public static final String GOLD_STATUS = "Gold";

	public static final int DEFAULT_BALANCE_INITIAL_VALUE = 10000;

	private int balance = DEFAULT_BALANCE_INITIAL_VALUE;

	private String username;

	private String email;

	private int ytdMiles = 0;

	public Flyer(String username, String email) {
		this.username = username;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		if (ytdMiles < 25000) {
			return RED_STATUS;
		} else if (ytdMiles < 50000) {
			return GREEN_STATUS;
		} else if (ytdMiles < 75000) {
			return BLUE_STATUS;
		}
		return GOLD_STATUS;
	}

	public void setYtdMiles(int miles) {
		ytdMiles = miles;
	}

	public int getYtdMiles() {
		return ytdMiles;
	}

	public int getBalance() {
		return balance;
	}

}
