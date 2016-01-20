package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	
	private Map<String, Member> members = new HashMap<>();	// <username, member>
	
	public MemberDao() {
	}
	
	public Member getMember(String username) {
		return members.get(username);
	}
	
	public void registerMember(String username, String email) {
		if(members.containsKey(username)) {
			throw new DuplicateMemberException();
		}
		Member member = new Member(username, email);
		members.put(username, member);
	}

}
