package com.tddair.features;

import com.tddair.Member;
import com.tddair.TddAirApplication;

public class CucumberSharedDataHolder {
	
	private TddAirApplication app;
	private Member member1;
	private String duplicateMessage;
	
	private static CucumberSharedDataHolder instance;
	
	private CucumberSharedDataHolder()
	{
		app = new TddAirApplication();
	}
	
	public static CucumberSharedDataHolder getInstance()
	{
		if(instance == null)
		{
			instance = new CucumberSharedDataHolder();
		}
		return instance;
	}

	public TddAirApplication getApp() {
		return app;
	}

	public void setApp(TddAirApplication app) {
		this.app = app;
	}

	public Member getMember1() {
		return member1;
	}

	public void setMember1(Member member1) {
		this.member1 = member1;
	}

	public String getDuplicateMessage() {
		return duplicateMessage;
	}

	public void setExceptionMessage(String duplicateMessage) {
		this.duplicateMessage = duplicateMessage;
	}
	
	

}
