package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {

	private Map<String, Member> members = new HashMap<>();
	
	public String registerMember(String username, String email) {
		String registrationStatus = MemberConstants.REGISTRATION_DUPLICATE;
			
		if (!members.containsKey(username)) {
			Member m = new Member(username, email);
			members.put(username, m);	
			
			registrationStatus = MemberConstants.REGISTRATION_SUCCESSFUL;
		}
		
		return registrationStatus;
	}

	public Member getMember(String username) {
		Member m = members.get(username);
		return m;
	}
}
