package com.tddair;

import com.tddair.constants.Status;

public class Member {
	private String userName;
	private String emailAddress;
	private Status status;
	private int rewardBalance;
	private int ytdBalance;
	
	public Member() {
		this("", "");
	}
	
	public Member(String userName, String email) {
		this(userName, email, Status.RED, 10000, 0);
	}
	
	public Member(final String userName, final String emailAddress, final Status status, 
			final int rewardBalance, final int ytdBalance) {
		setUserName(userName);
		setEmailAddress(emailAddress);
		setStatus(status);
		setRewardsBalance(rewardBalance);
		setYtdBalance(ytdBalance);
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
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(final Status status) {
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
