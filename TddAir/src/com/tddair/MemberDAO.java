package com.tddair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.tddair.constants.ErrorMessage;
import com.tddair.constants.Status;
import com.tddair.exceptions.DuplicateUserNameException;

public class MemberDAO {
	private final List<Member> members = new ArrayList<>();
	
	public void add(final Member member) throws DuplicateUserNameException {

		if (this.getMemberByUserName(member.getUserName()) != null)
			throw new DuplicateUserNameException(ErrorMessage.DUPLICATE_USER); 
		
		this.members.add(member);
	}

	public void addAll(final Collection<? extends Member> members) throws DuplicateUserNameException {
		for(final Member memberToAdd : members) {
			this.add(memberToAdd);
		}
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
	
	public int getNumMembers() {
		return this.members.size();
	}
	
	/**
	 * Returns a list of all the stored members
	 * @return A list of all the stored members. 
	 */
	public List<Member> getAllMembers() {
		return this.members;
	}

	public void incrementBalanceForCompleteFlight(Member member, int mileage) {
		//Increment Rewards Balance and YTD Balance for given mileage for a flight
		member.setRewardsBalance(member.getRewardBalance() + mileage);
		member.setYtdBalance(member.getYtdBalance() + mileage);
	}

	public void checkUpgradeStatus(Member member) {
		int currentYTDBalance = member.getYtdBalance();
		Status currentStatus = member.getStatus();
		
		if (currentStatus.isLowerThan(Status.GREEN) && currentYTDBalance > Status.GREEN.getMinLevelMiles()) {
			member.setStatus(Status.GREEN);
		} else if (currentStatus.isLowerThan(Status.BLUE) && currentYTDBalance > Status.BLUE.getMinLevelMiles()) {
			member.setStatus(Status.BLUE);
		} else if (currentStatus.isLowerThan(Status.GOLDEN) && currentYTDBalance > Status.GOLDEN.getMinLevelMiles()) {
			member.setStatus(Status.GOLDEN);
		}
		
	}
}
