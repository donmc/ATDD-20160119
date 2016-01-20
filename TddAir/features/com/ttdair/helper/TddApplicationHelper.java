package com.ttdair.helper;

import com.tddair.Member;
import com.tddair.TddAirApplication;

public class TddApplicationHelper {
	
	private static TddAirApplication instance = new TddAirApplication();
	private static Member member;
	
	public static TddAirApplication retrieveTddApp () {
		if (instance == null) {
			instance = new TddAirApplication();
		}
		return instance;
	}
	
	public static void setMember(Member memberParam) {
		member = memberParam;
	}
	
	public static Member getMember() {
		return member;
	}

}
