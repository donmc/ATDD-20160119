package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class MemberDB {
	
	private Map<String, Member> members = new HashMap<>();
	private static MemberDB instance = new MemberDB();
	
	private MemberDB()
	{
		
	}
	
	public static MemberDB getMemberDB()
	{
		return instance;
	}
	
	public void addMember(Member member) throws Exception
	{
		if(member.getUserName() != null && members.containsKey(member.getUserName()))
		{
			throw new Exception("Duplicate user name !!");
		} 
		else 
		{
			members.put(member.getUserName(), member);
		}
	}
	
	public Member getMember(String userName)
	{
		return members.get(userName);
	}
}
