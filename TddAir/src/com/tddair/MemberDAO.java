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


	public Member getMemberByUserName(final String userName) {
		for(final Member m : members) {
			if(m.getUserName().equals(userName)) {
				return m;
			}
		}
		
		// no match found
		return null;
	}
	
	public Member getMemberByEmailAddress(final String emailAddress) {
		for(final Member m : members) {
			if(m.getEmailAddress().equals(emailAddress)) {
				return m;
			}
		}
		
		// no match found
		return null;
	}

	public boolean hasMemberWithUserName(String userName) {
		return (this.getMemberByUserName(userName) != null);
	}
	
	public boolean hasMemberWithEmailAddress(String email) {
		return (this.getMemberByEmailAddress(email) != null);
	}
}
