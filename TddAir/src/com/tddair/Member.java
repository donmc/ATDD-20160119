package com.tddair;

import com.tddair.constants.Status;

public class Member {
	private String userName;
	private String emailAddress;
	private String status;
	private int rewardBalance;
	private int ytdBalance;
	
	public Member() {
		this("", "");
	}
	
	public Member(String userName, String email) {
		this(userName, email, Status.RED, 10000, 0);
	}
	
	public Member(final String userName, final String emailAddress, final String status, 
			final int rewardBalance, final int ytdBalance) {
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.status = status;
		this.rewardBalance = rewardBalance;
		this.ytdBalance = ytdBalance;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(final String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(final String status) {
		this.status = status;
	}

	public int getRewardBalance() {
		return rewardBalance;
	}
	
	public int getYtdBalance() {
		return ytdBalance;
	}

	public void setRewardsBalance(int rewardBalance) {
		this.rewardBalance = rewardBalance;
	}

	public void setYtdBalance(int ytdBalance) {
		this.ytdBalance = ytdBalance;
	}
}
