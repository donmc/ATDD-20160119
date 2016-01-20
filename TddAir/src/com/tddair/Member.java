package com.tddair;

public class Member {

	private String userName;
	private Category status;

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
		// TODO Auto-generated method stub
		return Category.Red;
	}

	public void setStatus(Category status) {
		this.status = status;
	}

	public Integer getYtdMiles() {
		// TODO Auto-generated method stub
		return null;
	}

}
