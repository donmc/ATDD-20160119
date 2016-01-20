package com.tddair;

public class Member {

	private String userName;
	private Category status;
	private Integer milesBalance;

	public Member(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Category getStatus() {
		return Category.Red;
	}

	public void setStatus(Category status) {
		this.status = status;
	}

	public Integer getYtdMiles() {
		return new Integer(0);
	}

	public Integer getMilesBalance() {
		// TODO Auto-generated method stub
		return this.milesBalance;
	}

	public void setMilesBalance(Integer milesBalance) {
		this.milesBalance = milesBalance;
	}

}
