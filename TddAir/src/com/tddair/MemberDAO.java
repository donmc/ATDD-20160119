package com.tddair;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	
	private List<Member> members;
	
	public MemberDAO()
	{
		members = new ArrayList<Member>();
	}

	public void saveMember(Member newMember)
	{
		members.add(newMember);
	}
	
	public Member getMember(String userName)
	{
		Member found = null;
		for(Member member: members)
		{
			if(member.getUserName().equals(userName))
			{
				found = member;
			}
		}
		return found;
	}
}
