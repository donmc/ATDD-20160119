package com.tddair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemberDAO {
	private final List<Member> members = new ArrayList<>();
	
	public void clear() {
		this.members.clear();
	}
	
	public boolean add(final Member member) {
		return this.members.add(member);
	}

	public boolean addAll(final Collection<? extends Member> members) {
		return this.members.addAll(members);
	}


	public boolean hasMemberWithUserName(final String userName) {
		for(final Member m : members) {
			if(m.getUserName().equals(userName)) {
				return true;
			}
		}
		
		// no match found
		return false;
	}
	
	public boolean hasMemberWithEmailAddress(final String emailAddress) {
		for(final Member m : members) {
			if(m.getEmailAddress().equals(emailAddress)) {
				return true;
			}
		}
		
		// no match found
		return false;
	}
}
