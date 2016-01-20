package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {

	private Map<String, Flyer> members = new HashMap();

	public MemberDao() {

	}

	public Flyer getByUserName(String username) {
		return members.get(username);
	}

	public void addMember(Flyer flyer) {
		members.put(flyer.getUsername(), flyer);
	}

}
