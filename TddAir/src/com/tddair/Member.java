package com.tddair;

public class Member {
	
	private String userName;
	private String email;
	private MemberStatus status;
	private long ytdMiles;
	private long balanceMiles;
	
	public Member(String userName, String email)
	{
		this.userName = userName;
		this.email = email;
	} 
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public MemberStatus getStatus() {
		return status;
	}

	public void setStatus(MemberStatus status) {
		this.status = status;
	}

	public long getYtdMiles() {
		return ytdMiles;
	}

	public void setYtdMiles(long ytdMiles) {
		this.ytdMiles = ytdMiles;
	}

	public long getBalanceMiles() {
		return balanceMiles;
	}

	public void setBalanceMiles(long balanceMiles) {
		this.balanceMiles = balanceMiles;
	}

}
