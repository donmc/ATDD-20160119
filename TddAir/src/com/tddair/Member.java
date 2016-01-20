package com.tddair;

public class Member {
	private String userName;
	private String emailAddress;
	private String status;
	private int totalBalance;
	private int ytdBalance;
	
	public Member() {
		this("", "", "Red", 0, 0);
	}
	
	public Member(final String userName, final String emailAddress, final String status, 
			final int totalBalance, final int ytdBalance) {
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.status = status;
		this.totalBalance = totalBalance;
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
	
	public int getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(final int totalBalance) {
		this.totalBalance = totalBalance;
	}
	
	public int getYtdBalance() {
		return ytdBalance;
	}
	public void setYtdBalance(final int ytdBalance) {
		this.ytdBalance = ytdBalance;
	}
}
