package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {

	private Map<String, Member> members = new HashMap<>();
	
	public void registerMember(String username, String email) {
		Member member = new Member(username, email);
		members.put(username, member);
	}

	public Member getMember(String username) {
		Member m = members.get(username);
		return m;
	}

	public boolean contains(String username) {
		return members.containsKey(username);
	}
}
