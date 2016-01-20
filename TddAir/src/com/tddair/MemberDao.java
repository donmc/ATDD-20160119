package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {

	private Map<String, Flyer> members = new HashMap<String, Flyer>();

	public MemberDao() {

	}

	public Flyer getByUserName(String username) {
		return members.get(username);
	}

	public void addMember(Flyer flyer) {
		if (members.containsKey(flyer.getUsername())) {
			throw new DuplicateUserException();
		}
		members.put(flyer.getUsername(), flyer);
	}

	public void updateMember(Flyer member) {
		members.put(member.getUsername(), member);
	}

}
