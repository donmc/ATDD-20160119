package com.tddair;

public class Member {
	
	private String username;
	private String email;
	private int status;
	private int milesBalance;
	private int ytdMiles;

	public Member(String username, String email) {
		this.username = username;
		this.email = email;
		this.status = Constants.RED_STATUS;
		this.milesBalance = 10000;
		this.ytdMiles = 0;
	}
	
	public void completeFlight(Flight flight) {
		this.ytdMiles += flight.getMileage();
		if(ytdMiles >= 75000) {
			status = Constants.GOLDEN_STATUS;
		} else if(ytdMiles >= 50000  && this.status < Constants.BLUE_STATUS) {
			status = Constants.BLUE_STATUS;
		} else if(ytdMiles >= 25000 && this.status < Constants.GREEN_STATUS) {
			status = Constants.GREEN_STATUS;
		} else if(this.status == Constants.RED_STATUS){
			status = Constants.RED_STATUS;
		}
	}

	public String getUserName() {
		return username;
	}

	public String getStatus() {
		return Constants.STATUS_MAP.get(status);
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public int getMilesBalance() {
		return milesBalance;
	}

	public int getYtdMiles() {
		return ytdMiles;
	}

	public void setYtdMiles(int ytdMiles) {
		this.ytdMiles = ytdMiles;
	}

	
}
